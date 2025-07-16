package com.example.ERPNext.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ERPNext.entity.BonCommande;
import com.example.ERPNext.entity.DemandeDevis;
import com.example.ERPNext.entity.DevisItem;
import com.example.ERPNext.entity.Fournisseur;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
    
    @GetMapping("/listFournisseur")     // LISTE DES FOURNISSEURS
    public String getListFournisseur(Model model) {

        String url = "http://erpnext.localhost:8000/api/resource/Supplier";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, request, String.class
            );

            String json = response.getBody();

            // Parse JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);
            JsonNode dataArray = root.path("data");

            List<Fournisseur> fournisseurs = new ArrayList<>();
            for (JsonNode node : dataArray) {
                String name = node.path("name").asText();
                fournisseurs.add(new Fournisseur(name));
            }

            model.addAttribute("fournisseurs", fournisseurs);
            model.addAttribute("body", "fournisseur/listeFournisseur");
            return "layout";

        } catch (HttpClientErrorException e) {
            model.addAttribute("message", "Fournisseur introuvable");
            model.addAttribute("body", "fournisseur/listeFournisseur");
            return "layout";
        } catch (Exception e) {
            model.addAttribute("message", "Erreur lors de la récupération");
            model.addAttribute("body", "fournisseur/listeFournisseur");
            return "layout";
        }
    }

    @GetMapping("/demandesDevis")       // SUPPLIER QUOTATION
    public String getListeDemandesDevis(@RequestParam("fournisseur") String nameFournisseur, Model model) {

        // String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation";
        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation" +
                    "?filters=[[\"supplier\",\"=\",\"" + nameFournisseur + "\"]]" +
                    "&fields=[\"name\",\"transaction_date\",\"status\",\"supplier\",\"total\",\"currency\"]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            String json = response.getBody();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);
            JsonNode dataArray = root.path("data");

            List<DemandeDevis> demandes = new ArrayList<>();
            for (JsonNode node : dataArray) {
                String name = node.path("name").asText();
                String transaction_date = node.path("transaction_date").asText();
                String status = node.path("status").asText();
                String supplier = node.path("supplier").asText();
                String total = node.path("total").asText();
                String currency = node.path("currency").asText();
                demandes.add(new DemandeDevis(name, transaction_date, status, supplier, total, currency));
            }

            model.addAttribute("demandes", demandes);
            model.addAttribute("body", "fournisseur/listeDemandeDevis");
            return "layout";

        } catch (HttpClientErrorException e) {
            model.addAttribute("message", "Demandes non trouvées pour ce fournisseur.");
            model.addAttribute("body", "fournisseur/listeDemandeDevis");
            return "layout";
        } catch (Exception e) {
            model.addAttribute("message", "Erreur lors de la récupération des demandes.");
            model.addAttribute("body", "fournisseur/listeDemandeDevis");
            return "layout";
        }

    }

    @GetMapping("/devisDetails")        //  GET ITEM PAR RAPPORT SUPPLIER QUOTATION -> NAME
    public String getDetailsDevis(@RequestParam("quotationName") String quotationName, Model model) {
        
        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation/" + quotationName;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode dataNode = objectMapper.readTree(response.getBody()).path("data");

            JsonNode itemsArray = dataNode.path("items");
            List<DevisItem> items = new ArrayList<>();

            for (JsonNode itemNode : itemsArray) {
                String itemCode = itemNode.path("item_code").asText();
                String name = itemNode.path("name").asText();
                String description = itemNode.path("description").asText();
                int qty = itemNode.path("qty").asInt();
                double rate = itemNode.path("rate").asDouble();

                items.add(new DevisItem(itemCode,name,description, qty, rate));
            }

            model.addAttribute("items", items);
            model.addAttribute("quotationId", quotationName);
            model.addAttribute("body", "fournisseur/listeItemDemandeDevis");
            return "layout";

        } catch (Exception e) {
            model.addAttribute("message", "Erreur lors de la récupération du devis.");
            model.addAttribute("body", "fournisseur/listeItemDemandeDevis");
            return "layout";
        }

    }

    // @PostMapping("/modifierPrixItem")       // MODIFIER PRIX ITEM PAR NAME
    // public String modifierPrixItem(
    //     @RequestParam("itemId") String itemId,
    //     @RequestParam("nouveauPrix") double nouveauPrix,
    //     @RequestParam("quotationId") String quotationId,
    //     RedirectAttributes redirectAttributes) {
    
    //     String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation Item/" + itemId;
    
    //     RestTemplate restTemplate = new RestTemplate();
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("rate", nouveauPrix);
    
    //     HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
    
    //     try {
    //         restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("message", "Erreur lors de la modification du prix item");
    //     }
    
    //     return "redirect:/fournisseur/devisDetails?quotationName=" + quotationId;
    // }

    @PostMapping("/modifierPrixItem")
    public String modifierPrixItem(
        @RequestParam("itemId") String itemId,
        @RequestParam("nouveauPrix") double nouveauPrix,
        @RequestParam("quotationId") String quotationId,
        RedirectAttributes redirectAttributes) {

        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation Item/" + itemId;
        String submitUrl = "http://erpnext.localhost:8000/api/resource/Supplier Quotation/" + quotationId + "?run_method=submit";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("rate", nouveauPrix);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            // Met à jour le prix de l'item
            restTemplate.exchange(url, HttpMethod.PUT, request, String.class);

            // Soumet le Supplier Quotation
            HttpEntity<String> submitRequest = new HttpEntity<>(headers);
            restTemplate.postForEntity(submitUrl, submitRequest, String.class);

            redirectAttributes.addFlashAttribute("message", "Prix modifié et devis soumis avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Erreur lors de la modification ou soumission : " + e.getMessage());
        }

        return "redirect:/fournisseur/devisDetails?quotationName=" + quotationId;
    }

    
    @GetMapping("/allCommandes")        // LISTE PURCHASE ORDER
    public String getListCommandes(@RequestParam("fournisseur") String nameFournisseur,Model model) {

        String url = "http://erpnext.localhost:8000/api/resource/Purchase Order?filters=[[\"supplier\",\"=\",\"" + nameFournisseur + "\"]]&fields=[\"*\"]";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            String json = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);
            JsonNode dataArray = root.path("data");

            List<BonCommande> bonCommande = new ArrayList<>();
            for (JsonNode node : dataArray) {
                String supplier = node.path("supplier").asText();
                String status = node.path("status").asText();
                String transaction_date = node.path("transaction_date").asText();
                double pourc_billed = node.path("per_billed").asDouble();
                double pourc_received = node.path("per_received").asDouble();
                String grand_total = node.path("grand_total").asText();
                String name = node.path("name").asText();

                bonCommande.add(new BonCommande(supplier, status, transaction_date, pourc_billed, pourc_received, grand_total, name));
            }

            model.addAttribute("bonCommande", bonCommande);
            model.addAttribute("fournisseur", nameFournisseur);
            model.addAttribute("body", "fournisseur/listeBonCommande");
            return "layout";

        } catch (HttpClientErrorException e) {
            model.addAttribute("message", "Fournisseur introuvable");
            model.addAttribute("body", "fournisseur/listeBonCommande");
            return "layout";
        } catch (Exception e) {
            model.addAttribute("message", "Erreur lors de la récupération");
            model.addAttribute("body", "fournisseur/listeBonCommande");
            return "layout";
        }
        
    }

    @PostMapping("/allCommandesfilter")     // PURCHASE ORDER FILTER STATUS
    public String getListCommandesfilter(@RequestParam("fournisseur") String nameFournisseur,@RequestParam("status") String statusParam,Model model) {

        String url = "http://erpnext.localhost:8000/api/resource/Purchase Order"
                    + "?filters=[[\"supplier\",\"=\",\"" + nameFournisseur + "\"],[\"status\",\"=\",\"" + statusParam + "\"]]"
                    + "&fields=[\"*\"]";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            String json = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(json);
            JsonNode dataArray = root.path("data");

            List<BonCommande> bonCommande = new ArrayList<>();
            for (JsonNode node : dataArray) {
                String supplier = node.path("supplier").asText();
                String status = node.path("status").asText();
                String transaction_date = node.path("transaction_date").asText();
                double pourc_billed = node.path("per_billed").asDouble();
                double pourc_received = node.path("per_received").asDouble();
                String grand_total = node.path("grand_total").asText();
                String name = node.path("name").asText();

                bonCommande.add(new BonCommande(supplier, status, transaction_date, pourc_billed, pourc_received, grand_total, name));
            }

            model.addAttribute("bonCommande", bonCommande);
            model.addAttribute("fournisseur", nameFournisseur);
            model.addAttribute("body", "fournisseur/listeBonCommande");
            return "layout";

        } catch (HttpClientErrorException e) {
            model.addAttribute("message", "Fournisseur introuvable");
            model.addAttribute("body", "fournisseur/listeBonCommande");
            return "layout";
        } catch (Exception e) {
            model.addAttribute("message", "Erreur lors de la récupération");
            model.addAttribute("body", "fournisseur/listeBonCommande");
            return "layout";
        }
        
    }

}

// @PostMapping("/modifierPrixItem")       // MODIFIER PRIX ITEM PAR NAME
//     public String modifierPrixItem(
//         @RequestParam("itemId") String itemId,
//         @RequestParam("nouveauPrix") double nouveauPrix,
//         @RequestParam("quotationId") String quotationId,
//         RedirectAttributes redirectAttributes) {
    
//         String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation Item/" + itemId;
    
//         RestTemplate restTemplate = new RestTemplate();
//         HttpHeaders headers = new HttpHeaders();
//         headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
//         headers.setContentType(MediaType.APPLICATION_JSON);
    
//         Map<String, Object> body = new HashMap<>();
//         body.put("rate", nouveauPrix);
    
//         HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
    
//         try {
//             restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
//         } catch (Exception e) {
//             redirectAttributes.addFlashAttribute("message", "Erreur lors de la modification du prix item");
//         }
    
//         return "redirect:/fournisseur/devisDetails?quotationName=" + quotationId;
//     }
