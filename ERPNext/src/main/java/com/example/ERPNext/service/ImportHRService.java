package com.example.ERPNext.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.ERPNext.entity.frappeHR.MultipartInputStreamFileResource;

@Service
public class ImportHRService {
    
    public boolean areAllFilesCSV(MultipartFile... files) {

        for (MultipartFile file : files) {
            if (file == null || file.isEmpty()) return false;

            String filename = file.getOriginalFilename();
            if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
                return false;
            }
        }
        return true;
        
    }

    public ResponseEntity<String> resetDatabase() throws Exception {
        String url = "http://erpnext.localhost:8000/api/method/hrms.api.database_management.reset_database_rest";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return response;
    }

    public ResponseEntity<String> importCsv(
        @RequestParam("fichier1") MultipartFile fichier1,
        @RequestParam("fichier2") MultipartFile fichier2,
        @RequestParam("fichier3") MultipartFile fichier3) throws IOException {

        String url = "http://erpnext.localhost:8000/api/method/hrms.api.database_management.import_csv";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file1", new MultipartInputStreamFileResource(fichier1.getInputStream(), fichier1.getOriginalFilename()));
        body.add("file2", new MultipartInputStreamFileResource(fichier2.getInputStream(), fichier2.getOriginalFilename()));
        body.add("file3", new MultipartInputStreamFileResource(fichier3.getInputStream(), fichier3.getOriginalFilename()));

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
       
        return response;
    }

    public Map<String,Integer> getNombreLigneFichierImport (MultipartFile... files) throws IOException {
        Map<String,Integer> fichierEtNomberLigne = new HashMap<>();
        for (MultipartFile multipartFile : files) {
            if (!multipartFile.isEmpty()) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))) {
                    int ligne = 0 ;
                    while (reader.readLine() != null) {
                        ligne ++;
                    }
                    if (ligne > 0) ligne -= 1 ;
                    fichierEtNomberLigne.put(multipartFile.getOriginalFilename(), ligne);
                }
            } else {
                fichierEtNomberLigne.put(multipartFile.getOriginalFilename(), 0);
            }
        }
        return fichierEtNomberLigne;
    }

}
