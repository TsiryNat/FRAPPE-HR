package com.example.ERPNext.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @GetMapping("/showLogin")
    public String showLoginPage(Model model) {
        // model.addAttribute("erreur", null);
        return "utilisateur/login";
    }

    @PostMapping("/checklogin")
    public String loginToErpNext(@RequestParam("email") String email,
                                                @RequestParam("password") String password,
                                                RedirectAttributes redirectAttributes) {

        String url = "http://erpnext.localhost:8000/api/method/login";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String jsonBody = """
            {
                "usr": "%s",
                "pwd": "%s"
            }
        """.formatted(email, password);

        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            
            if (response.getStatusCode().is2xxSuccessful()) {
                return "redirect:/fournisseur/listFournisseur";
            } else {
                redirectAttributes.addFlashAttribute("erreur", "Erreur d'authentification.");
                return "redirect:/login/showLogin";
            }

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            redirectAttributes.addFlashAttribute("erreur", "Email ou mot de passe invalide.");
            return "redirect:/login/showLogin";
        }
    }

}
