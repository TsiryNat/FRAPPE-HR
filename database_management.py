import csv
import io
import datetime
import re
import frappe
from frappe import _


GENDER_MAPPING = {
    "masculin": "Male",
    "feminin": "Female",
    "male": "Male",
    "female": "Female"
}


@frappe.whitelist()
def import_csv():
    file1 = frappe.local.request.files.get("file1")
    file2 = frappe.local.request.files.get("file2")
    file3 = frappe.local.request.files.get("file3")

    if not file1 or not file2 or not file3:
        return {"status": "error", "content": "One or some file(s) is/are missing."}
            
    [data_file1, error_file1] = read_csv(file1)
    [data_file2, error_file2] = read_csv(file2)
    [data_file3, error_file3] = read_csv(file3)
    
    errors = error_file1 + error_file2 + error_file3
    errors = "".join(errors)
    if len(errors)!=0:
        print(str(errors))
        # return {"status": "error", "content": f"{str(errors)}"} 
        return {"status": "error", "content": f"<ul>{str(errors)}</ul>"} 
    
    record = insert_data(data_file1, data_file2, data_file3)
    return {"status": "success", "content": record}
    # return {"status": "success", "content": f"Files imported successfuly."}



def insert_data(data_file1, data_file2, data_file3):
    record = []
    company_record = 0
    employee_record = 0
    salary_comp_record = 0
    salary_struct_record = 0
    salary_detail_record = 0
    salary_struct_assign_record = 0
    try:
        # file 1: Company and Employee
        # Company
        # index_comp = data_file1[0].index("company")
        # insert_companies(companies)
        companies = [line[6] for line in data_file1]
        for company in companies:
            if not frappe.db.exists("Company", company):
                company_doc = frappe.get_doc({
                    "name": company,
                    "doctype": "Company",
                    "company_name": company,
                    "country": "Madagascar",
                    "default_currency": "EUR",
                    "abbr": "C" 
                })
                company_doc.insert(ignore_permissions=True)
                company_record += 1
        record.append(f"<li>{company_record} Company inserted.</li>")
        # Employee
        for data in data_file1:
            name = f"HR-EMP-{int(data[0]):05d}"
            if not frappe.db.exists("Employee", name):
                employee_doc = frappe.get_doc({
                    "name": name,
                    "doctype": "Employee",
                    "employee": name,
                    "holiday_list": "Holiday", # creeo alo ty
                    "employee_name": data[1]+ " "+data[2],
                    "first_name": data[1],
                    "last_name": data[2],
                    "gender": GENDER_MAPPING.get(data[3].lower(), data[3]),
                    "date_of_joining": data[4],
                    "date_of_birth": data[5],
                    "status": "Active",
                    "company": data[6]
                })
                employee_doc.insert(ignore_permissions=True)
                employee_record += 1
        record.append(f"<li>{employee_record} Employee inserted.</li>")

        # file 2: Company, Salary Components , Salary Structure, Salary Detail
        # companies = [line[5] for line in data_file1]
        # insert_companies(companies)    
        sal_components = [(line[1], line[2], line[3], line[4]) for line in data_file2]
        # Salary Components
        for component in sal_components:
            if not frappe.db.exists("Salary Component", component[0]):
                component_doc = frappe.get_doc({
                    "name": component[0],
                    "doctype": "Salary Component",
                    "salary_component": component[0],
                    "depends_on_payment_days": 0,
                    "salary_component_abbr": component[1],
                    "type": component[2].lower().capitalize(),
                    # "type": component[2],
                    "amount_based_on_formula": 1,
                    "formula": component[3]
                })
                component_doc.insert(ignore_permissions=True)
                salary_comp_record += 1
        record.append(f"<li>{salary_comp_record} `Salary Component` inserted.</li>")
        # Salary Structure
        for data in data_file2:
            if not frappe.db.exists("Salary Structure", data[0]):
                sal_struc_doc = frappe.get_doc({
                    "name": data[0],
                    "doctype": "Salary Structure",
                    "payroll_frequency": "Monthly",
                    "currency": "EUR",
                    "docstatus": 0,
                    "is_active": "Yes",
                    "company": data[5]
                })
                sal_struc_doc.insert(ignore_permissions=True)
                sal_struc_doc.submit()
                salary_struct_record += 1
        # Salary Detail
            existing_sal_detail = frappe.db.sql("""
                    SELECT * FROM `tabSalary Detail` WHERE
                    LOWER(parent) = LOWER(%s) AND 
                    LOWER(salary_component) = LOWER(%s)
                    LIMIT 1""", (data[0], data[1],),
                as_dict=True)
            # print(f"existing sal detail {existing_sal_detail}")
            if not existing_sal_detail:
                sal_detail_doc = frappe.get_doc({
                    "doctype": "Salary Detail",
                    "payroll_frequency": "Monthly",
                    "parent": data[0],
                    "docstatus":  0,
                    "condition": "",
                    "salary_component": data[1],
                    "abbr": data[2],
                    "parentfield": "earnings" if data[3].lower() == "earning" else "deductions",
                    "parenttype": "Salary Structure",
                    "amount_based_on_formula": 1,
                    "formula": data[4]
                })
                sal_detail_doc.insert(ignore_permissions=True)
                salary_detail_record += 1
        record.append(f"<li>{salary_detail_record} `Salary Detail` inserted.</li>")
        record.append(f"<li>{salary_struct_record} `Salary Structure` inserted.</li>")

        # file 3: Salary Structure Assignment
        for data in data_file3:
            employee_ref = f"HR-EMP-{int(data[1]):05d}"
            sal_struct_ass_doc = frappe.get_doc({
                "from_date": data[0],
                "employee": employee_ref,
                "doctype": "Salary Structure Assignment",
                "docstatus": 0,
                "base": data[2],
                "salary_structure": data[3]
            })
            sal_struct_ass_doc.insert(ignore_permissions=True)
            sal_struct_ass_doc.submit()
            salary_struct_assign_record += 1
        record.append(f"<li>{salary_struct_assign_record} `Salary Structure Assignment` inserted.</li>")

        frappe.db.commit()
    except Exception as e:
        frappe.log_error(f"File 3 : Error Frappe SQL : {str(e)}")
        frappe.throw(_("Error trying to access data."))
    
    record = "".join(record)
    return f"<ul>{str(record)}</ul>"


# def insert_companies(companies):
#     for company in companies:
#         existing_company = frappe.db.sql(
#             "SELECT name FROM `tabCompany` WHERE LOWER(company_name) = LOWER(%s) LIMIT 1", (company,),
#             as_dict=True
#         )
#         if not existing_company:
#             company_doc = frappe.get_doc({
#                 "doctype": "Company",
#                 "company_name": company,
#                 "country": "Madagascar",
#                 "default_currency": "EUR",
#                 "abbr": "C" 
#             })
#             company_doc.insert(ignore_permissions=True)
#             frappe.db.commit()



def read_csv(file):
    content = file.stream.read().decode("utf-8")
    csv_reader = csv.reader(io.StringIO(content), delimiter=',')

    errors = []
    rows = []
    lines = []
    column_nb = 0        # column number per line
    for row_index, row in enumerate(csv_reader):
        if row_index == 0:
            column_nb = len(row)
        else:
            if column_nb != len(row):
                # errors.append(f"- Column number is different at line {row_index+1}.\n")
                errors.append(f"<li>Column number is different at line {row_index+1}.</li>\n")
            else:
                for cell_index, cell in enumerate(row):
                    converted_value, errors = check_data_error(cell, errors, row_index, cell_index)
                    lines.append(converted_value)
                rows.append(lines)
                lines = []
    # errors = [f'File: {file.filename}']+errors  if len(errors) != 0 else []
    errors = [f'<br><p style="font-weight:bold; font-size: 16px;">File: {file.filename}</p>']+errors  if len(errors) != 0 else []
    
    print(f"\nTitle file : {file}")
    print(f"Data :\n {rows}")
    print(f"Errors :\n {errors}\n")
    
    return rows, errors
    
    
    
"""
    This function convert the cell data from the csv into his corresponding value
    and check if there are data errors (date format, negative value, None value,...)
"""
# v1
# def check_data_error(value, errors, row_index, cell_index): 
#     value = value.strip()
#     if value == "":
#         # errors.append(f"- No value, at line {row_index+1}, column {cell_index+1}.\n")
#         errors.append(f"<li>No value, at line {row_index+1}, column {cell_index+1}.</li>\n")
#         return None, errors
#     try:
#         value = int(value)
#         if value <= 0:
#             # errors.append(f"- Negative int value, at line {row_index+1}, column {cell_index+1}.\n")
#             errors.append(f"<li>Negative int value, at line {row_index+1}, column {cell_index+1}.</li>\n")
#     except ValueError:
#         try:
#             value = float(value)
#             if value <= 0:
#                 # errors.append(f"- Negative float value, at line {row_index+1}, column {cell_index+1}.\n")
#                 errors.append(f"<li>Negative float value, at line {row_index+1}, column {cell_index+1}.</li>\n")
#         except ValueError:
#             try:
#                 value = mysql_date_format(value)
#             except ValueError:
#                 # errors.append(f"- Wrong date format at line {row_index+1}, column {cell_index+1}.\n")
#                 errors.append(f"<li>Wrong date format at line {row_index+1}, column {cell_index+1}.</li>")
#     print(f"Value : {value}")
#     return value, errors



# v2
def check_data_error(value, errors, row_index, cell_index):
    value = value.strip()
    if not value:
        errors.append(f"<li>No value at line {row_index+1}, column {cell_index}.</li>\n")
        return None, errors

    if re.fullmatch(r"[+-]?\d+", value):
        value = int(value)
        if value <= 0:
            errors.append(f"<li>Non-positive integer at line {row_index+1}, column {cell_index}.</li>\n")
        return value, errors

    if re.fullmatch(r"[+-]?\d+[.,]\d+", value):
        # fv = float(value.replace(",", "."))
        if value <= 0:
            errors.append(f"<li>Non-positive float at line {row_index+1}, column {cell_index}.</li>\n")
        return value, errors

    # if re.fullmatch(r"\d{1,2}[-/ ]\d{1,2}[-/ ]\d{4}", value):
    if re.fullmatch(r"\d+[-/ ]\d+[-/ ]\d+", value):
        try:
            value = mysql_date_format(value)
            return value, errors
        except ValueError:
            errors.append(f"<li>Wrong date format at line {row_index+1}, column {cell_index}. Must be in 'd/m/Y' format.</li>\n")
            return None, errors
        
    # Ampio contraintes izay ilaina
    return value, errors



def mysql_date_format(value):   
    date = datetime.datetime.strptime(value, "%d/%m/%Y").strftime("%Y-%m-%d")
    return date



# def reset_database():
#     # modules = frappe.get_all("Module Def", filters={"is_custom": 0}, fields=["name"])
#     # doctypes = [""]
#     modules = ["custom-module"]
#     for module in modules:
#         doctypes_in_module = frappe.get_all("DocType", filters={"module": module}, fields=["name"])
#         for doctype in doctypes_in_module:
#         # for doctype in doctypes:
#             table_name = f"{doctype.name}"
            
#             if frappe.db.table_exists(table_name):
#                 try:
#                     frappe.db.truncate(table_name)            
#                     print(f"{table_name} truncated.")
#                 except Exception as e:
#                     frappe.log_error(frappe.get_traceback(), _("Error truncating table"))
#                     frappe.msgprint(_(f"Failed to truncate table {table_name}: {str(e)}"))
#     frappe.msgprint(_(f"Tables {modules} truncated successfulty."))
    
    
    
@frappe.whitelist()
def reset_database_rest():
    # modules = frappe.get_all("Module Def", filters={"is_custom": 0}, fields=["name"])
    frappe.db.sql("UPDATE `tabSeries` SET `current`=0 WHERE `name`='HR-EMP-'")
    doctypes = [
        "Employee", "Salary Structure Assignment", "Salary Structure", "Salary Component", "Salary Detail",
        "Salary Slip"    
    ]
    # modules = ["custom-module"]
    # for module in modules:
    # doctypes = frappe.get_all("DocType", filters={"module": module}, fields=["name"])
    for doctype in doctypes:
        table_name = f"{doctype}"
        
        if frappe.db.table_exists(table_name):
            try:
                frappe.db.truncate(table_name)            
                print(f"{table_name} truncated.")
            except Exception as e:
                return {"status": "error", "content": f"Failed to truncate table {table_name}: {str(e)}"}
    
    return {
        "status": "success",
        "content":f"""
                <ul>
                    <li>Tables <span style="font-weight:800">{doctypes}</span> truncated successfulty.</li>
                    <li>'HR-EMP-' index from table <span style="font-weight:800">'Series'</span> set to 0.</li>
                </ul>
            """
    }
    
    