package com.example.ERPNext.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.loader.ast.internal.MultiKeyLoadChunker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ERPNext.entity.frappeHR.EmployeAndSalaryComponent;
import com.example.ERPNext.entity.frappeHR.SalarySlipHR;
import com.example.ERPNext.entity.frappeHR.StatisticSalaryHR;
import com.example.ERPNext.entity.frappeHR.TabPourcentageDeductionSalaire;
import com.example.ERPNext.service.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/employeeHR")
public class EmployeeHRController {
    
    @Autowired
    private EmployeeHRService employeeHRService;

    @Autowired
    private ImportHRService importHRService;

    @Autowired
    private TabPourcentageDeductionSalaireService tabPourcentageDeductionSalaireService;

    @Autowired
    private HistoriqueSalarySlipService historiqueSalarySlipService;

    @GetMapping("/resetDatabase")
    public String resetDatabase(Model model) {

        try {
            ResponseEntity<String> responseEntity = importHRService.resetDatabase();
            JsonNode root = new ObjectMapper().readTree(responseEntity.getBody());
            String content = root.path("message").path("content").asText();
            
            model.addAttribute("message", "Base de données réinitialisée avec succès.");
            model.addAttribute("htmlMessage", content);
        } catch (Exception e) {
            model.addAttribute("message", "Erreur : " + e.getMessage());
            e.printStackTrace();
        }

        model.addAttribute("body", "HR/ImportData");
        return "layout";

    }

    @GetMapping("/formImportData")
    public String formImportData(Model model) {

        model.addAttribute("body", "HR/ImportData");
        return "layout";

    }

    @PostMapping("/importData")
    public String importData(
        @RequestParam("fichier1") MultipartFile fichier1,
        @RequestParam("fichier2") MultipartFile fichier2,
        @RequestParam("fichier3") MultipartFile fichier3,
        Model model) {

        try {
            ResponseEntity<String> response = importHRService.importCsv(fichier1, fichier2, fichier3);
            JsonNode root = new ObjectMapper().readTree(response.getBody());
            String content = root.path("message").path("content").asText();
            
            model.addAttribute("message", "Import effectué : " + response.getBody());
            model.addAttribute("htmlMessage", content);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de l'import : " + e.getMessage());
        }
      
        model.addAttribute("body", "HR/ImportData");
        return "layout";
    }

    @PostMapping("/verifierLigneDonnee")
    public String verifierLigneDonnee(
        @RequestParam("fichier1") MultipartFile fichier1,
        @RequestParam("fichier2") MultipartFile fichier2,
        @RequestParam("fichier3") MultipartFile fichier3,
        Model model) {

        try {
            Map<String,Integer> fichierEtNomberLigne = importHRService.getNombreLigneFichierImport(fichier1,fichier2,fichier3);
            model.addAttribute("nombreLignes", fichierEtNomberLigne);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de l'import : " + e.getMessage());
        }
      
        model.addAttribute("body", "HR/VoirNomberLigneFichier");
        return "layout";
    }

    @GetMapping("/voirHistorique")
    public String voirHistorique(Model model) {
        
        model.addAttribute("historique", historiqueSalarySlipService.getAll());
        model.addAttribute("body", "HR/HistoriqueSalarySlip");
        return "layout";
    }

    @GetMapping("/listEmployee")
    public String listEmployee(Model model) {

        try {
            model.addAttribute("employee", employeeHRService.getAllEmployes());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            model.addAttribute("message", "employee introuvable");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la récupération");
        }

        model.addAttribute("body", "HR/listeEmployee");
        return "layout";

    }

    @PostMapping("/listEmployeeWithFilter")
    public String listEmployeeWithFilter(@RequestParam("recherche") String recherche,Model model) {

        try {
            model.addAttribute("employee", employeeHRService.getAllEmployesWithFilters(recherche));
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            model.addAttribute("message", "employee introuvable");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la récupération");
        }

        model.addAttribute("body", "HR/listeEmployee");
        return "layout";

    }

    @GetMapping("/formSalarySlip")
    public String formSalarySlip(Model model) {
        
        try {
            model.addAttribute("employee", employeeHRService.getAllEmployes());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            model.addAttribute("message", "employee introuvable");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la récupération");
        }

        model.addAttribute("body", "HR/createSalarySlip");
        return "layout";

    }

    @PostMapping("/createSalarySlip")
    public String createSalarySlip(
            @RequestParam("employee_name") String employeeName,
            @RequestParam("date_debut") String dateDebut,
            @RequestParam("date_fin") String dateFin,
            @RequestParam("salaire") String salaire,
            @RequestParam(value = "moyenne", required = false) String moyenne,
            @RequestParam(value = "ecrase", required = false) String ecrase,
            Model model) {

        try {
            model.addAttribute("employee", employeeHRService.getAllEmployes());
            model.addAttribute("message", employeeHRService.generatedSalarySlip(employeeName, dateDebut, dateFin,salaire,moyenne,ecrase));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la création de la Salary Slip");
        }

        model.addAttribute("body", "HR/createSalarySlip");
        return "layout";

    }

    @GetMapping("/formModificationSalaire")
    public String formModificationSalaire(Model model) {

        try {
            model.addAttribute("salaryComponent", employeeHRService.getAllSalaryComponent());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la salary component");
        }

        model.addAttribute("body", "HR/modificationSalaire");
        return "layout";

    }

    @PostMapping("/modificationSalaire")
    public String modificationSalaire(
        @RequestParam("salaryComponentName") String salaryComponentName,
        @RequestParam("condition") String condition,
        @RequestParam("montant") String montant,
        @RequestParam("nouvelleSalaireBase") String nouvelleSalaireBase,
        @RequestParam("pourcentage") String pourcentage,
        Model model) {

        try {
            model.addAttribute("salaryComponent", employeeHRService.getAllSalaryComponent());
            employeeHRService.modificationSalaireBase(salaryComponentName, condition, montant, nouvelleSalaireBase, pourcentage);
            model.addAttribute("message", "Modification reuissi avec success");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la modification salaire de base");
        }

        model.addAttribute("body", "HR/modificationSalaire");
        return "layout";

    }

    @GetMapping("/rechercheSalaireEtEmployee")
    public String rechercheSalaireEtEmployee(Model model) {

        try {
            model.addAttribute("salaryComponent", employeeHRService.getAllSalaryComponent());
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la salary component");
        }

        model.addAttribute("body", "HR/rechercheSalaireEtEmployee");
        return "layout";

    }

    @PostMapping("/rechercheSalaireEtEmployeePost")
    public String rechercheSalaireEtEmployeePost(
        @RequestParam("salaryComponentName") String salaryComponentName,
        @RequestParam("condition") String condition,
        @RequestParam("montant") String montant,
        Model model) {

        try {
            model.addAttribute("salaryComponent", employeeHRService.getAllSalaryComponent());
            List<SalarySlipHR> salarySlipHR = employeeHRService.filterSalarySlipByComponent(salaryComponentName, condition, Double.parseDouble(montant));
            List<String> champ = employeeHRService.getNomChampSalaryComponent2(salarySlipHR);
            model.addAttribute("salarySlip", salarySlipHR);
            model.addAttribute("nomChamp",champ);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la modification salaire de base");
        }

        model.addAttribute("body", "HR/rechercheSalaireEtEmployee");
        return "layout";

    }

    @GetMapping("/test")
    public String test(RedirectAttributes redirectAttributes) {

        List<TabPourcentageDeductionSalaire> list = tabPourcentageDeductionSalaireService.getAll();
        for (TabPourcentageDeductionSalaire tabPourcentageDeductionSalaire : list) {
            System.out.println("==================");
            System.out.println("id : " + tabPourcentageDeductionSalaire.getIdPds());
            System.out.println("mois : " + tabPourcentageDeductionSalaire.getMois());
            System.out.println("valeur : " + tabPourcentageDeductionSalaire.getValeur());
        }
        return "redirect:/employeeHR/salarySlip";

    }


    @GetMapping("/ficheEmployeAvecSalaire")
    public String ficheEmployeAvecSalaire(@RequestParam("employeeID") String employeeID,Model model) {

        try {
            model.addAttribute("employe", employeeHRService.getEmployeeHRById(employeeID));
            model.addAttribute("assignments", employeeHRService.getAvecAssignmentsByEmployee(employeeID));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la récupération de la fiche employé.");
        }

        model.addAttribute("body", "HR/ficheEmployeAvecSalaire");
        return "layout";

    }

    @GetMapping("/salarySlip")
    public String salarySlip(Model model) {
        try {
            List<SalarySlipHR> salarySlipHR = employeeHRService.getSalarySlip();
            List<String> champ = employeeHRService.getNomChampSalaryComponent2(salarySlipHR);
            model.addAttribute("salarySlip", salarySlipHR);
            model.addAttribute("nomChamp",champ);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la récupération Salary slip");
        }
        model.addAttribute("body", "HR/salarySlip");
        return "layout";
    }

    @GetMapping("/salarySlipDetails")
    public String salarySlipDetails(@RequestParam("salaryId") String salaryId,Model model) {
        try {
            model.addAttribute("salarySlipDetail", employeeHRService.getSalarySlipDetails(salaryId));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la récupération Salary slip");
        }
        model.addAttribute("body", "HR/detailSalarySlip");
        return "layout";
    }

    @GetMapping("/exportPDF")
    public String exportPDF(@RequestParam("salaryId") String salaryId,RedirectAttributes redirectAttributes) {
        try {
            employeeHRService.downloadSalarySlipPDF(salaryId);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            System.out.println("=========>>>>>>> Exception : " + e.getMessage());
        }
        return "redirect:/employeeHR/salarySlipDetails?salaryId=" + salaryId;
    }

    @GetMapping("/employeAndSalaryComponent")
    public String EmployeAndSalaryComponent(Model model) {
        try {
            double total = 0;
            List<EmployeAndSalaryComponent>  employeAndSalaryComponents = employeeHRService.getEmployeeAndSalaryComponent("");
            List<String> listeChamp = employeeHRService.getNomChampSalaryComponent(employeAndSalaryComponents);
            for (EmployeAndSalaryComponent employeAndSalaryComponent : employeAndSalaryComponents) {
                total += employeAndSalaryComponent.getAssignment().getBase();
            }
            model.addAttribute("nomChamp",listeChamp);
            model.addAttribute("employeAndSalaryComponent",employeAndSalaryComponents);
            model.addAttribute("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la employe avec elemenet des salaires");
        }
        model.addAttribute("body", "HR/employeAndSalaryComponent");
        return "layout";
    }
    
    @PostMapping("/employeAndSalaryComponentFilterByDate")
    public String EmployeAndSalaryComponentFilterByDate(@RequestParam("date") String date,Model model) {
        try {
            double total = 0;
            List<EmployeAndSalaryComponent>  employeAndSalaryComponents = employeeHRService.getEmployeeAndSalaryComponent(date);
            List<String> listeChamp = employeeHRService.getNomChampSalaryComponent(employeAndSalaryComponents);
            for (EmployeAndSalaryComponent employeAndSalaryComponent : employeAndSalaryComponents) {
                total += employeAndSalaryComponent.getAssignment().getBase();
            }
            model.addAttribute("nomChamp",listeChamp);
            model.addAttribute("employeAndSalaryComponent",employeAndSalaryComponents);
            model.addAttribute("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la employe avec elemenet des salaires");
        }
        model.addAttribute("body", "HR/employeAndSalaryComponent");
        return "layout";
    }

    @GetMapping("/employeAndSalaryComponentFilterByDate2")
    public String EmployeAndSalaryComponentFilterByDate2(@RequestParam("date") String date,Model model) {
        try {
            double total = 0;
            List<EmployeAndSalaryComponent>  employeAndSalaryComponents = employeeHRService.getEmployeeAndSalaryComponent(date);
            List<String> listeChamp = employeeHRService.getNomChampSalaryComponent(employeAndSalaryComponents);
            for (EmployeAndSalaryComponent employeAndSalaryComponent : employeAndSalaryComponents) {
                total += employeAndSalaryComponent.getAssignment().getBase();
            }
            model.addAttribute("nomChamp",listeChamp);
            model.addAttribute("employeAndSalaryComponent",employeAndSalaryComponents);
            model.addAttribute("total",total);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la employe avec elemenet des salaires");
        }
        model.addAttribute("body", "HR/employeAndSalaryComponent");
        return "layout";
    }

    @GetMapping("/getStatistiqueByYear")
    public String getStatistiqueByYear(@RequestParam("year") String year,Model model) {
        try {
            List<EmployeAndSalaryComponent>  employeAndSalaryComponents = employeeHRService.getEmployeeAndSalaryComponent("");
            List<String> listeChamp = employeeHRService.getNomChampSalaryComponent(employeAndSalaryComponents);
            List<StatisticSalaryHR> statisticSalaryHRs = employeeHRService.getStatistiqueByYear(year);
            model.addAttribute("annee",year);
            model.addAttribute("statistiqueSalary",statisticSalaryHRs);
            model.addAttribute("nomChamp",listeChamp);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la Statistique des salaire des employees");
        }
        model.addAttribute("body", "HR/statisticSalary");
        return "layout";
    }

    @PostMapping("/getStatistiqueByYearPost")
    public String getStatistiqueByYearPost(@RequestParam("year") String year,Model model) {
        try {
            List<EmployeAndSalaryComponent>  employeAndSalaryComponents = employeeHRService.getEmployeeAndSalaryComponent("");
            List<String> listeChamp = employeeHRService.getNomChampSalaryComponent(employeAndSalaryComponents);
            List<StatisticSalaryHR> statisticSalaryHRs = employeeHRService.getStatistiqueByYear(year);
            model.addAttribute("annee",year);
            model.addAttribute("statistiqueSalary",statisticSalaryHRs);
            model.addAttribute("nomChamp",listeChamp);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la Statistique des salaire des employees");
        }
        model.addAttribute("body", "HR/statisticSalary");
        return "layout";
    }

    @GetMapping("/graphe")
    public String graphe(Model model) {
        try {
            List<StatisticSalaryHR> statisticSalaryHR = employeeHRService.getStatistiqueByYear("2025");
            List<String> mois = new ArrayList<>();
            List<Double> salaireParMois = new ArrayList<>();
            // mois.add("");
            // salaireParMois.add(0.0);
            for (StatisticSalaryHR ssHR : statisticSalaryHR) {
                mois.add(ssHR.getMois());
                salaireParMois.add(ssHR.getTotalBase());
            }
            model.addAttribute("salaireParMois", salaireParMois);
            model.addAttribute("mois", mois);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la Statistique des salaire des employees");
        }

        model.addAttribute("body", "HR/graphe");
        return "layout";
    }

    @PostMapping("/graphe2")
    public String graphe2(@RequestParam("year") String year,Model model) {
        try {
            List<StatisticSalaryHR> statisticSalaryHR = employeeHRService.getStatistiqueByYear(year);
            List<String> mois = new ArrayList<>();
            List<Double> salaireParMois = new ArrayList<>();
            // mois.add("");
            // salaireParMois.add(0.0);
            for (StatisticSalaryHR ssHR : statisticSalaryHR) {
                mois.add(ssHR.getMois());
                salaireParMois.add(ssHR.getTotalBase());
            }
            model.addAttribute("salaireParMois", salaireParMois);
            model.addAttribute("mois", mois);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Erreur lors de la Statistique des salaire des employees");
        }

        model.addAttribute("body", "HR/graphe");
        return "layout";
    }

}