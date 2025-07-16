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

import com.example.ERPNext.entity.Facture;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/comptable")
public class ComptableController {
    
    @GetMapping("/allFactureAchat")
    public String getListFactureAchat(Model model) {

        String url = "http://erpnext.localhost:8000/api/resource/Purchase Invoice?fields=[\"*\"]";
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

            List<Facture> factures = new ArrayList<>();
            for (JsonNode node : dataArray) {
                String supplier = node.path("supplier").asText();
                String status = node.path("status").asText();
                String posting_date = node.path("posting_date").asText();
                String grand_total = node.path("grand_total").asText();
                String name = node.path("name").asText();

                factures.add(new Facture(supplier, status, posting_date, grand_total, name));
            }

            model.addAttribute("factures", factures);
            model.addAttribute("body", "comptable/listeFactureAchat");
            return "layout";

        } catch (HttpClientErrorException e) {
            model.addAttribute("message", "Purchase invoice introuvable");
            model.addAttribute("body", "comptable/listeFactureAchat");
            return "layout";
        } catch (Exception e) {
            model.addAttribute("message", "Erreur lors de la récupération");
            model.addAttribute("body", "comptable/listeFactureAchat");
            return "layout";
        }
        
    }

    @GetMapping("/formPaymentEntry")
    public String showFormPaymentEntry(
        @RequestParam("invoiceName") String invoiceName,
        @RequestParam("amount") String amount,
        @RequestParam("supplier") String supplier,
        Model model) {
        model.addAttribute("invoiceName", invoiceName);
        model.addAttribute("amount", amount);
        model.addAttribute("supplier", supplier);
        model.addAttribute("body", "comptable/PaymentEntry");
        return  "layout";
    }

    @PostMapping("/payerFacture")       // PAYMENT ENTRY
    public String payerFacture(
            @RequestParam("posting_date") String posting_date,
            @RequestParam("payment_type") String payment_type,
            @RequestParam("party_type") String party_type,
            @RequestParam("party") String party,
            @RequestParam("amount") double montant,
            @RequestParam("paid_from") String paid_from,
            @RequestParam("paid_to") String paid_to,
            @RequestParam("mode_of_payment") String mode_of_payment,
            @RequestParam("reference_no") String reference_no,
            @RequestParam("reference_date") String reference_date,
            @RequestParam("invoiceName") String invoiceName,
            RedirectAttributes redirectAttributes) {

        String url = "http://erpnext.localhost:8000/api/resource/Payment Entry";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("posting_date", posting_date);
        body.put("payment_type", payment_type);
        body.put("party_type", party_type);
        body.put("party", party);
        body.put("paid_amount", montant);
        body.put("received_amount", montant);
        body.put("paid_from", paid_from);
        body.put("paid_to", paid_to);
        body.put("reference_doctype", "Purchase Invoice");
        body.put("mode_of_payment", mode_of_payment);
        body.put("reference_name", invoiceName);
        body.put("reference_no", reference_no);
        body.put("reference_date", reference_date);
        body.put("references", List.of(
            Map.of(
                "reference_doctype", "Purchase Invoice",
                "reference_name", invoiceName,
                "total_amount", montant,
                "outstanding_amount", montant,
                "allocated_amount", montant
            )
        ));

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            String paymentEntryName = root.path("data").path("name").asText();
        
            // Appel de la soumission
            String submitUrl = "http://erpnext.localhost:8000/api/resource/Payment Entry/" + paymentEntryName + "?run_method=submit";
            HttpEntity<String> submitRequest = new HttpEntity<>(headers);
            restTemplate.postForEntity(submitUrl, submitRequest, String.class);
        
            redirectAttributes.addFlashAttribute("message", "Facture payée et soumise avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Erreur lors du paiement : " + e.getMessage());
        }
        

        return "redirect:/comptable/allFactureAchat";
    }
    

}

    // @PostMapping("/payerFacture")       // PAYMENT ENTRY
    // public String payerFacture(
    //         @RequestParam("payment_type") String payment_type,
    //         @RequestParam("party_type") String party_type,
    //         @RequestParam("party") String party,
    //         @RequestParam("amount") double montant,
    //         @RequestParam("paid_from") String paid_from,
    //         @RequestParam("paid_to") String paid_to,
    //         @RequestParam("invoiceName") String invoiceName,
    //         RedirectAttributes redirectAttributes) {

    //     String url = "http://erpnext.localhost:8000/api/resource/Payment Entry";

    //     RestTemplate restTemplate = new RestTemplate();
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
    //     headers.setContentType(MediaType.APPLICATION_JSON);

    //     Map<String, Object> body = new HashMap<>();
    //     body.put("payment_type", "Pay");
    //     body.put("party_type", "Supplier");
    //     body.put("party", "Nom du fournisseur"); // remplace par le vrai nom du fournisseur
    //     body.put("paid_amount", montant);
    //     body.put("received_amount", montant);
    //     body.put("paid_from", "Cash"); // ou "Bank", selon ta config
    //     body.put("paid_to", "Creditors"); // compte fournisseur
    //     body.put("reference_doctype", "Purchase Invoice");
    //     body.put("reference_name", invoiceName);
    //     body.put("references", List.of(
    //         Map.of(
    //             "reference_doctype", "Purchase Invoice",
    //             "reference_name", invoiceName,
    //             "total_amount", montant,
    //             "outstanding_amount", montant,
    //             "allocated_amount", montant
    //         )
    //     ));

    //     HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

    //     try {
    //         ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
    //         redirectAttributes.addFlashAttribute("message", "Facture payée avec succès !");
    //     } catch (Exception e) {
    //         redirectAttributes.addFlashAttribute("message", "Erreur lors du paiement : " + e.getMessage());
    //     }

    //     return "redirect:/listeFactures"; // redirige vers ta page de factures
    // }