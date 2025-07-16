import frappe
from frappe import _
from frappe.utils import getdate
from frappe.utils import flt

@frappe.whitelist(allow_guest=False)
def delete_salary_structure_assignment(employee_name, start_date, end_date):

    """
    Vérifie si une Salary Structure Assignment existe pour un employé donné
    avec une date égale à start_date, end_date ou entre start_date et end_date.
    Si elle existe, la supprime.
    
    Args:
        employee_name (str): Nom de l'employé (champ 'employee_name' dans ERPNext)
        start_date (str): Date de début au format 'YYYY-MM-DD'
        end_date (str): Date de fin au format 'YYYY-MM-DD'
    
    Returns:
        dict: Résultat de l'opération avec statut et message
    """

    try:
        if not employee_name or not start_date or not end_date:
            return {"status": "error", "message": _("Missing required parameters.")}

        start_date = getdate(start_date)
        end_date = getdate(end_date)

        employee = frappe.get_list("Employee", filters={"name": employee_name}, fields=["name"])
        if not employee:
            return {"status": "error", "message": _(f"No employee found with name: {employee_name}")}

        employee_id = employee[0].name

        assignments = frappe.get_list(
            "Salary Structure Assignment",
            filters={
                "employee": employee_id,
                "from_date": ["between", [start_date, end_date]]
            },
            fields=["name", "docstatus"]
        )

        if not assignments:
            return {"status": "success", "message": _(f"No Salary Structure Assignment found.")}

        deleted_assignments = []
        for assignment in assignments:
            doc = frappe.get_doc("Salary Structure Assignment", assignment.name)
            if doc.docstatus == 1:
                doc.cancel()  # Annule
            doc.delete()      # Supprime
            deleted_assignments.append(assignment.name)

        frappe.db.commit()

        return {
            "status": "success",
            "message": _(f"Deleted Salary Structure Assignments: {', '.join(deleted_assignments)}")
        }

    except Exception as e:
        frappe.db.rollback()
        return {
            "status": "error",
            "message": _(f"Error deleting Salary Structure Assignment: {str(e)}")
        }


        
# ======================= autre fonction ===========================
# ==================================================================
# ==================================================================
# ==================================================================
# ==================================================================


@frappe.whitelist(allow_guest=False)
def calculate_average_base_salary(date):
    
    """
    Calcule la moyenne des salaires de base des Salary Structure Assignments
    pour tous les employés dont la date est inférieure à date.
    
    Args:
        date (str): Date limite au format 'YYYY-MM-DD'
    
    Returns:
        dict: Résultat avec la moyenne des salaires de base et le nombre d'assignations
    """
    try:
        # Valider le paramètre
        if not date:
            return {
                "status": "error",
                "message": _("Missing required parameter: date")
            }
        
        # Convertir la date en objet datetime
        date = getdate(date)
        
        # Rechercher tous les Salary Structure Assignments avec from_date < date
        assignments = frappe.get_list(
            "Salary Structure Assignment",
            filters={
                "from_date": ["<", date],
                "docstatus": 1  # Considérer uniquement les documents validés
            },
            fields=["base"]
        )
        
        if not assignments:
            return {
                "status": "success",
                "message": _(f"No Salary Structure Assignments found before {date}"),
                "average_salary": 0.0,
                "count": 0
            }
        
        # Calculer la moyenne des salaires de base
        total_base = sum(assignment.base for assignment in assignments if assignment.base is not None)
        count = len([assignment for assignment in assignments if assignment.base is not None])
        
        average_salary = total_base / count if count > 0 else 0.0
        
        return {
            "status": "success",
            "message": _(f"Average base salary calculated for {count} assignments"),
            "average_salary": round(average_salary, 2),
            "count": count
        }
    
    except Exception as e:
        frappe.db.rollback()
        return {
            "status": "error",
            "message": _(f"Error calculating average base salary: {str(e)}")
        }


# ======================= autre fonction ===========================
# ==================================================================
# ==================================================================
# ==================================================================
# ==================================================================


@frappe.whitelist(allow_guest=False)
def delete_salary_slip_by_name(name):
    try:
        if not name:
            return {
                "status": "error",
                "message": _("Salary Slip name is required.")
            }

        # Récupérer le document
        salary_slip = frappe.get_doc("Salary Slip", name)

        # Si soumis, le cancel d'abord
        if salary_slip.docstatus == 1:
            salary_slip.cancel()
            frappe.db.commit()

        # Supprimer le document
        frappe.delete_doc("Salary Slip", name)
        frappe.db.commit()

        return {
            "status": "success",
            "message": _(f"Salary Slip {name} deleted successfully.")
        }

    except Exception as e:
        frappe.db.rollback()
        return {
            "status": "error",
            "message": _(f"Error deleting Salary Slip: {str(e)}")
        }
        
        

# ======================= autre fonction ===========================
# ==================================================================
# ==================================================================
# ==================================================================
# ==================================================================

@frappe.whitelist()
def filter_salary_slip_by_component(component_name, condition, amount):
    
    """
    Filtrer les Salary Slips selon un composant de salaire, une condition et un montant.
    
    Args:
        component_name (str): Le nom du salary component (ex. "Income Tax")
        condition (str): "inferieur", "egale", "superieur"
        amount (float): Le montant de référence

    Returns:
        dict: Liste des salary slips filtrés
    """
    try:
        if not component_name or not condition or amount is None:
            return {
                "status": "error",
                "message": _("Tous les paramètres sont obligatoires.")
            }

        # Récupérer tous les Salary Slips valides
        salary_slips = frappe.get_all(
            "Salary Slip",
            filters={"docstatus": 1},
            fields=["name", "employee", "employee_name", "start_date", "end_date" , "salary_structure" , "company"]
        )

        results = []
        for slip in salary_slips:
            slip_doc = frappe.get_doc("Salary Slip", slip.name)

            for earning in slip_doc.earnings:
                if earning.salary_component == component_name:
                    value = flt(earning.amount)

                    if condition == "inferieur" and value < amount:
                        results.append(slip)
                        break
                    elif condition == "egale" and value == amount:
                        results.append(slip)
                        break
                    elif condition == "superieur" and value > amount:
                        results.append(slip)
                        break

            for deduction in slip_doc.deductions:
                if deduction.salary_component == component_name:
                    value = flt(deduction.amount)

                    if condition == "inferieur" and value < amount:
                        results.append(slip)
                        break
                    elif condition == "egale" and value == amount:
                        results.append(slip)
                        break
                    elif condition == "superieur" and value > amount:
                        results.append(slip)
                        break

        return {
            "status": "success",
            "message": _("Salary Slips trouvés."),
            "salary_slips": results
        }

    except Exception as e:
        frappe.log_error(message=str(e), title="filter_salary_slip_by_component Error")
        return {
            "status": "error",
            "message": str(e)
        }

        
        
# @frappe.whitelist(allow_guest=False)
# def delete_salary_structure_assignment(employee_name, start_date, end_date):
  
#     """
#     Vérifie si une Salary Structure Assignment existe pour un employé donné
#     avec une date égale à start_date, end_date ou entre start_date et end_date.
#     Si elle existe, la supprime.
    
#     Args:
#         employee_name (str): Nom de l'employé (champ 'employee_name' dans ERPNext)
#         start_date (str): Date de début au format 'YYYY-MM-DD'
#         end_date (str): Date de fin au format 'YYYY-MM-DD'
    
#     Returns:
#         dict: Résultat de l'opération avec statut et message
#     """
  
#     try:
#         # Valider les paramètres
#         if not employee_name or not start_date or not end_date:
#             return {
#                 "status": "error",
#                 "message": _("Missing required parameters: employee_name, start_date, or end_date")
#             }
        
#         # Convertir les dates en objets datetime pour comparaison
#         start_date = getdate(start_date)
#         end_date = getdate(end_date)
        
#         # Rechercher l'employé par son nom
#         employee = frappe.get_list(
#             "Employee",
#             filters={"name": employee_name},
#             fields=["name"]
#         )
        
#         if not employee:
#             return {
#                 "status": "error",
#                 "message": _(f"No employee found with name: {employee_name}")
#             }
        
#         employee_id = employee[0].name
        
#         # Rechercher les Salary Structure Assignments correspondant aux critères
#         assignments = frappe.get_list(
#             "Salary Structure Assignment",
#             filters={
#                 "employee": employee_id,
#                 "from_date": ["between", [start_date, end_date]]
#             },
#             fields=["name", "from_date"]
#         )
        
#         if not assignments:
#             return {
#                 "status": "success",
#                 "message": _(f"No Salary Structure Assignment found for {employee_name} between {start_date} and {end_date}")
#             }
        
#         # Supprimer les assignations trouvées
#         deleted_assignments = []
#         for assignment in assignments:
#             frappe.delete_doc("Salary Structure Assignment", assignment.name)
#             deleted_assignments.append(assignment.name)
        
#         # Valider la transaction
#         frappe.db.commit()
        
#         return {
#             "status": "success",
#             "message": _(f"Deleted Salary Structure Assignments: {', '.join(deleted_assignments)}")
#         }
    
#     except Exception as e:
#         frappe.db.rollback()
#         return {
#             "status": "error",
#             "message": _(f"Error deleting Salary Structure Assignment: {str(e)}")
#         }
        