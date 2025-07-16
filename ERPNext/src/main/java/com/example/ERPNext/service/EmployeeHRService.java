package com.example.ERPNext.service;

import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.ERPNext.entity.frappeHR.AssignmentHR;
import com.example.ERPNext.entity.frappeHR.CompanyHR;
import com.example.ERPNext.entity.frappeHR.EmployeAndSalaryComponent;
import com.example.ERPNext.entity.frappeHR.EmployeeHR;
import com.example.ERPNext.entity.frappeHR.HistoriqueSalarySlip;
import com.example.ERPNext.entity.frappeHR.SalaryComponentHR;
import com.example.ERPNext.entity.frappeHR.SalarySlipHR;
import com.example.ERPNext.entity.frappeHR.SalaryStructureHR;
import com.example.ERPNext.entity.frappeHR.StatisticSalaryHR;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeHRService {
    
    @Autowired
    private HistoriqueSalarySlipService historiqueSalarySlipService;

    public List<EmployeeHR> getAllEmployes() throws HttpClientErrorException , Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Employee?fields=[\"*\"]";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        String json = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(json);
        JsonNode dataArray = root.path("data");
        List<EmployeeHR> employee = objectMapper.convertValue(dataArray, new TypeReference<List<EmployeeHR>>() {});
           
        return employee;
    }

    public List<SalaryComponentHR> getAllSalaryComponent() throws HttpClientErrorException , Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Salary Component"
                + "?fields=[\"*\"]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        String json = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(json);
        JsonNode dataArray = root.path("data");
        List<SalaryComponentHR> salaryComponent = objectMapper.convertValue(dataArray, new TypeReference<List<SalaryComponentHR>>() {});
           
        return salaryComponent;
    }

    public List<EmployeeHR> getAllEmployesWithFilters(String recherche) throws HttpClientErrorException , Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Employee"
                    + "?fields=[\"*\"]"
                    + "&filters=[[\"employee_name\",\"like\",\"%" + recherche + "%\"]]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        String json = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(json);
        JsonNode dataArray = root.path("data");
        List<EmployeeHR> employee = objectMapper.convertValue(dataArray, new TypeReference<List<EmployeeHR>>() {});
           
        return employee;

    }

    public EmployeeHR getEmployeeHRById(String employeId) throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Employee"
                    + "?fields=[\"*\"]"
                    + "&filters=[[\"name\",\"like\",\"%" + employeId + "%\"]]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        JsonNode employeDataArray = new ObjectMapper().readTree(response.getBody()).path("data");
        EmployeeHR employee = new ObjectMapper().convertValue(employeDataArray,EmployeeHR[].class)[0];

        return employee;
    }

    public List<SalarySlipHR> getSalarySlip() throws Exception {

        String salairesUrl = "http://erpnext.localhost:8000/api/resource/Salary Slip"
                + "?fields=[\"*\"]"
                + "&order_by=start_date desc"
                + "&limit=500";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(salairesUrl, HttpMethod.GET, request, String.class);
        JsonNode salaryData = new ObjectMapper().readTree(response.getBody()).path("data");
        List<SalarySlipHR> salarySlip = new ObjectMapper().convertValue(salaryData, new TypeReference<List<SalarySlipHR>>() {});

        return salarySlip;
    }

    public SalarySlipHR getSalarySlipById(String salarySlipId) throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip/"
                    + salarySlipId
                    + "?fields=[\"*\"]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        JsonNode employeDataArray = new ObjectMapper().readTree(response.getBody()).path("data");
        SalarySlipHR salarySlipHR = new ObjectMapper().convertValue(employeDataArray,SalarySlipHR.class);

        return salarySlipHR;
    }

    public SalarySlipHR getSalarySlipDetails(String salaryId) throws Exception {

        String salairesUrl = "http://erpnext.localhost:8000/api/resource/Salary Slip"
                            + "?fields=[\"*\"]" 
                            + "&filters=[[\"name\",\"like\",\"%" + salaryId + "%\"]]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(salairesUrl, HttpMethod.GET, request, String.class);
        JsonNode salaryData = new ObjectMapper().readTree(response.getBody()).path("data");
        SalarySlipHR salarySlip = new ObjectMapper().convertValue(salaryData,SalarySlipHR[].class)[0];

        return salarySlip;
    }

    public void downloadSalarySlipPDF(String salarySlipName) throws Exception {

        String url = "http://erpnext.localhost:8000/api/method/frappe.utils.print_format.download_pdf" +
                    "?doctype=Salary Slip" +
                    "&name=" + salarySlipName +
                    "&format=Standard";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_PDF));

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<byte[]> response = restTemplate.exchange(url, HttpMethod.GET, request, byte[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            byte[] pdfBytes = response.getBody();

            try (FileOutputStream fos = new FileOutputStream("C:/Users/MSI/Downloads/fiche_paie.pdf")) {
                fos.write(pdfBytes);
            }

        } else {
            throw new Exception("Erreur lors du téléchargement du PDF. Code HTTP : " + response.getStatusCode());
        }
    }

    public List<AssignmentHR> getAllAssignments() throws Exception {

        String assignmentUrl = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment"
                + "?fields=[\"*\"]"
                + "&order_by=from_date desc"
                + "&limit=500";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> assignResponse = restTemplate.exchange(assignmentUrl, HttpMethod.GET, request, String.class);
        JsonNode assignArray = new ObjectMapper().readTree(assignResponse.getBody()).path("data");
        List<AssignmentHR> assignments = new ObjectMapper().convertValue(assignArray, new TypeReference<List<AssignmentHR>>() {});
            
        return assignments;
    }

    public List<AssignmentHR> getAllAssignmentsFilterByDate(String date) throws Exception {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inputDate = LocalDate.parse(date, inputFormatter);
        LocalDate firstDay = inputDate.withDayOfMonth(1);
        LocalDate lastDay = inputDate.withDayOfMonth(inputDate.lengthOfMonth());

        String assignmentUrl = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment"
                            + "?fields=[\"*\"]"
                            + "&filters=[[\"from_date\",\">=\",\"" + firstDay + "\"],[\"from_date\",\"<=\",\"" + lastDay + "\"]]"
                            + "&order_by=from_date desc"
                            + "&limit=500";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> assignResponse = restTemplate.exchange(assignmentUrl, HttpMethod.GET, request, String.class);
        JsonNode assignArray = new ObjectMapper().readTree(assignResponse.getBody()).path("data");
        List<AssignmentHR> assignments = new ObjectMapper().convertValue(assignArray, new TypeReference<List<AssignmentHR>>() {});
            
        return assignments;
    }

    public List<AssignmentHR> getAssignmentsByYear(int year) throws Exception {
        String startDate = year + "-01-01";
        String endDate = year + "-12-31";

        String assignmentUrl = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment"
                + "?fields=[\"*\"]"
                + "&filters=[[\"from_date\",\">=\",\"" + startDate + "\"],[\"from_date\",\"<=\",\"" + endDate + "\"]]"
                + "&order_by=from_date desc";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> assignResponse = restTemplate.exchange(assignmentUrl, HttpMethod.GET, request, String.class);
        JsonNode assignArray = new ObjectMapper().readTree(assignResponse.getBody()).path("data");

        List<AssignmentHR> assignments = new ObjectMapper().convertValue(assignArray, new TypeReference<List<AssignmentHR>>() {});
        return assignments;
    }

    public List<AssignmentHR> getAvecAssignmentsByEmployee(String employeeId) throws Exception {

        String assignmentUrl = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment"
                + "?fields=[\"*\"]"
                + "&filters=[[\"employee\",\"=\",\"" + employeeId + "\"]]"
                + "&order_by=from_date desc";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> assignResponse = restTemplate.exchange(assignmentUrl, HttpMethod.GET, request, String.class);
        JsonNode assignArray = new ObjectMapper().readTree(assignResponse.getBody()).path("data");
        List<AssignmentHR> assignments = new ObjectMapper().convertValue(assignArray, new TypeReference<List<AssignmentHR>>() {});
            
        return assignments;
    }

    public void createSalaryStructureAssignment(AssignmentHR assignmentHR) throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> body = objectMapper.convertValue(assignmentHR, new TypeReference<Map<String, Object>>() {});

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        JsonNode root = objectMapper.readTree(response.getBody());
        String assignmentName = root.path("data").path("name").asText();

        // ==================== status en submitted ========================== //

        String submitUrl = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment/" + assignmentName;
        Map<String, Object> submitBody = new HashMap<>();
        submitBody.put("docstatus", 1);  // 1 = Submitted

        HttpEntity<Map<String, Object>> submitRequest = new HttpEntity<>(submitBody, headers);
        restTemplate.exchange(submitUrl, HttpMethod.PUT, submitRequest, String.class);

        System.out.println("Salary Structure Assignment soumis avec succès : " + assignmentName);
    }

    public SalaryStructureHR getSalaryStructureByName (String salaryStructureId) throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure/" + salaryStructureId;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        JsonNode salaryData = new ObjectMapper().readTree(response.getBody()).path("data");
        // System.out.println(salaryData.toPrettyString());
        SalaryStructureHR salaryStructure = new ObjectMapper().convertValue(salaryData,SalaryStructureHR.class);

        return salaryStructure;
    }
   
    public SalaryStructureHR getOneSalaryStructure () throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure?fields=[\"*\"]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        JsonNode salaryData = new ObjectMapper().readTree(response.getBody()).path("data");
        SalaryStructureHR salaryStructure = new ObjectMapper().convertValue(salaryData,SalaryStructureHR[].class)[0];

        return salaryStructure;
    }

    public CompanyHR getOneCompany () throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Company?fields=[\"*\"]";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        JsonNode salaryData = new ObjectMapper().readTree(response.getBody()).path("data");
        CompanyHR company = new ObjectMapper().convertValue(salaryData,CompanyHR[].class)[0];

        return company;
    }

    public void createSalarySlip(SalarySlipHR salarySlipHR) throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> body = objectMapper.convertValue(salarySlipHR, new TypeReference<Map<String, Object>>() {});

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // ==================== status en submitted ========================== //
        JsonNode root = objectMapper.readTree(response.getBody());
        String salarySlipName = root.path("data").path("name").asText();

        String submitUrl = "http://erpnext.localhost:8000/api/resource/Salary Slip/" + salarySlipName;
        Map<String, Object> submitBody = new HashMap<>();
        submitBody.put("docstatus", 1);

        HttpEntity<Map<String, Object>> submitRequest = new HttpEntity<>(submitBody, headers);
        restTemplate.exchange(submitUrl, HttpMethod.PUT, submitRequest, String.class);

        System.out.println("Salary Slip créé avec succès !");
    
    }

    public void deleteSalaryStructureAssignment(String employeeName, String startDate, String endDate) throws Exception {

        String url = "http://erpnext.localhost:8000/api/method/hrms.api.metier.delete_salary_structure_assignment";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("employee_name", employeeName);
        body.put("start_date", startDate);
        body.put("end_date", endDate);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonResponse = mapper.readTree(response.getBody());
        String status = jsonResponse.path("message").path("status").asText();
        String message = jsonResponse.path("message").path("message").asText();

        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public double calculateAverageBaseSalary(String date) throws Exception {

        String url = "http://erpnext.localhost:8000/api/method/hrms.api.metier.calculate_average_base_salary";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("date", date);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody()).path("message");

        String status = root.path("status").asText();
        String message = root.path("message").asText();
        int count = root.path("count").asInt();
        double averageSalary = root.path("average_salary").asDouble();

        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
        System.out.println("Count: " + count);
        System.out.println("average salary: " + averageSalary);

        return averageSalary;
    }

    public AssignmentHR getLastAssignmentByEmployeeBeforeDate(String employeeId, String date) throws Exception {

        String assignmentUrl = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment"
                + "?fields=[\"*\"]"
                + "&filters=[[\"employee\",\"=\",\"" + employeeId + "\"], [\"from_date\", \"<=\", \"" + date + "\"]]"
                + "&order_by=from_date desc"
                + "&limit=1";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> assignResponse = restTemplate.exchange(assignmentUrl, HttpMethod.GET, request, String.class);
        JsonNode assignArray = new ObjectMapper().readTree(assignResponse.getBody()).path("data");

        List<AssignmentHR> assignments = new ObjectMapper().convertValue(assignArray, new TypeReference<List<AssignmentHR>>() {});
        
        if (!assignments.isEmpty()) {
            return assignments.get(0);  // Le plus récent trouvé
        } else {
            return null;  // Aucun résultat trouvé
        }
    }

    public List<SalarySlipHR> getSalarySlipsByEmployeeAndPeriod(String employeeId, String dateDebut, String dateFin) throws Exception {

        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip"
                + "?fields=[\"*\"]"
                + "&filters=[[\"employee\", \"=\", \"" + employeeId + "\"],"
                + "[\"start_date\", \">=\", \"" + dateDebut + "\"],"
                + "[\"end_date\", \"<=\", \"" + dateFin + "\"]]"
                + "&limit=500";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        JsonNode data = new ObjectMapper().readTree(responseEntity.getBody()).path("data");

        if (data.isArray() && data.size() > 0) {
            // Convertir en liste d’objets SalarySlipHR
            List<SalarySlipHR> salarySlips = new ObjectMapper().convertValue(data, new TypeReference<List<SalarySlipHR>>() {});
            return salarySlips;
        }

        // Aucun résultat trouvé
        return null;
    }

    public String deleteSalarySlipByName(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/method/hrms.api.metier.delete_salary_slip_by_name";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("name", name);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody());

        String status = root.path("message").path("status").asText();
        String message = root.path("message").path("message").asText();

        System.out.println("Status: " + status);
        System.out.println("Message: " + message);

        return message;
    }

    public List<SalarySlipHR> filterSalarySlipByComponent(String componentName, String condition, double amount) throws Exception {

        String url = "http://erpnext.localhost:8000/api/method/hrms.api.metier.filter_salary_slip_by_component";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("component_name", componentName);
        requestBody.put("condition", condition);
        requestBody.put("amount", amount);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody()).path("message");

        // Affichage dans la console uniquement
        System.out.println("Status: " + root.path("status").asText());
        System.out.println("Message: " + root.path("message").asText());

        // Conversion vers liste d'objets SalarySlipHR
        List<SalarySlipHR> salarySlips = objectMapper.convertValue(root.path("salary_slips"),new TypeReference<List<SalarySlipHR>>() {});

        return salarySlips;
    }

    public void setEarningsAndDeductionsSalarySlip (List<SalarySlipHR> salarySlip) throws Exception {
        for (SalarySlipHR ss : salarySlip) {
            SalarySlipHR ssDetails = getSalarySlipById(ss.getName());
            Map<String, Double> earningsAndDeduction = new HashMap<>();
            for (SalaryComponentHR salaryComponent : ssDetails.getEarnings()) {
                earningsAndDeduction.put(salaryComponent.getSalary_component(),salaryComponent.getAmount());
            }
            for (SalaryComponentHR salaryComponent : ssDetails.getDeductions()) {
                earningsAndDeduction.put(salaryComponent.getSalary_component(),salaryComponent.getAmount());
            }
            ss.setEarningsAndDeductions(earningsAndDeduction);
        }
    }

    public List<EmployeAndSalaryComponent> getEmployeeAndSalaryComponent (String date) throws Exception {   // all salary assignement -> salary structure (salary component)
        List<AssignmentHR> salaryStructureAssignment = null;
        List<EmployeAndSalaryComponent> employeAndSalaryComponents = new ArrayList<>();
        if (date == "") {
            salaryStructureAssignment = getAllAssignments();
        } else {
            salaryStructureAssignment = getAllAssignmentsFilterByDate(date);
        }
        for (AssignmentHR assignment : salaryStructureAssignment) {
            SalaryStructureHR salaryStructure = getSalaryStructureByName(assignment.getSalary_structure());
            employeAndSalaryComponents.add(new EmployeAndSalaryComponent(assignment, salaryStructure));
        }
        return employeAndSalaryComponents;
    }

    public List<String> getNomChampSalaryComponent (List<EmployeAndSalaryComponent> employeAndSalaryComponents) {
        List<String> nomChamp = new ArrayList<>();
        for (EmployeAndSalaryComponent employeAndSalaryComponent : employeAndSalaryComponents) {
            Map<String, Double> earningsAndDeduction = new HashMap<>();
            for (SalaryComponentHR salaryComponent : employeAndSalaryComponent.getSalaryStructure().getEarnings()) {
                earningsAndDeduction.put(salaryComponent.getSalary_component(),salaryComponent.getAmount());
                if (!nomChamp.contains(salaryComponent.getSalary_component())) {
                    nomChamp.add(salaryComponent.getSalary_component());
                }
            }
            for (SalaryComponentHR salaryComponent : employeAndSalaryComponent.getSalaryStructure().getDeductions()) {
                earningsAndDeduction.put(salaryComponent.getSalary_component(),salaryComponent.getAmount());
                if (!nomChamp.contains(salaryComponent.getSalary_component())) {
                    nomChamp.add(salaryComponent.getSalary_component());
                }
            }
            employeAndSalaryComponent.setEarningsAndDeductions(earningsAndDeduction);
        }
        return nomChamp;
    }

    public List<String> getNomChampSalaryComponent2 (List<SalarySlipHR> salarySlip) throws Exception {
        List<String> nomChamp = new ArrayList<>();
        for (SalarySlipHR ss : salarySlip) {
            SalarySlipHR ssDetails = getSalarySlipById(ss.getName());
            Map<String, Double> earningsAndDeduction = new HashMap<>();
            for (SalaryComponentHR salaryComponent : ssDetails.getEarnings()) {
                earningsAndDeduction.put(salaryComponent.getSalary_component(),salaryComponent.getAmount());
                if (!nomChamp.contains(salaryComponent.getSalary_component())) {
                    nomChamp.add(salaryComponent.getSalary_component());
                }
            }
            for (SalaryComponentHR salaryComponent : ssDetails.getDeductions()) {
                earningsAndDeduction.put(salaryComponent.getSalary_component(),salaryComponent.getAmount());
                if (!nomChamp.contains(salaryComponent.getSalary_component())) {
                    nomChamp.add(salaryComponent.getSalary_component());
                }
            }
            ss.setEarningsAndDeductions(earningsAndDeduction);
        }
        return nomChamp;
    }

    public  List<StatisticSalaryHR> getStatistiqueByYear (String year) throws Exception {
        List<StatisticSalaryHR> statisticSalary = new ArrayList<>();
        Map<String,String> listDate = listDate(year);

        for (Map.Entry<String,String> date : listDate.entrySet()) {
            List<EmployeAndSalaryComponent> employeAndSalaryComponents = getEmployeeAndSalaryComponent(date.getValue());
            if (!employeAndSalaryComponents.isEmpty()) {
                getNomChampSalaryComponent(employeAndSalaryComponents);
                statisticSalary.add(new StatisticSalaryHR(employeAndSalaryComponents,date.getKey(),date.getValue()));
            }
        }
        statisticSalary.sort(Comparator.comparing(stat -> LocalDate.parse(stat.date)));
        return statisticSalary;
    }

    public List<SalarySlipHR> searchSalarySlipsByCriteria(String employeeId, String salaryComponent, String condition, double amount) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token a15659789fb77b5:73e2b33e24a527d");
        HttpEntity<Void> request = new HttpEntity<>(headers);

        List<Object> filters = new ArrayList<>();

        // if (employeeId != null && !employeeId.isBlank()) {
        //     filters.add(List.of("employee", "=", employeeId));
        // }

        filters.add(List.of("earnings", "salary_component", "=", salaryComponent));
        filters.add(List.of("earnings", "amount", condition, amount));

        // Encodage du filtre en JSON
        ObjectMapper mapper = new ObjectMapper();
        String filterJson = URLEncoder.encode(mapper.writeValueAsString(filters), StandardCharsets.UTF_8);

        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip"
                + "?fields=[\"*\"]"
                + "&filters=" + filterJson
                + "&limit=500";

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        JsonNode data = mapper.readTree(response.getBody()).path("data");
        return mapper.convertValue(data, new TypeReference<List<SalarySlipHR>>() {});
    }

    public String generatedSalarySlip (
            String employeeId,
            String date_debut,
            String date_fin,
            String salaire,
            String moyenne,
            String ecrase
            ) throws Exception {

        EmployeeHR employeeHR = getEmployeeHRById(employeeId);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(date_debut, inputFormatter);
        LocalDate endDate = LocalDate.parse(date_fin, inputFormatter);
        List<YearMonth> yearMonth = getMonthlyPeriods(startDate, endDate);

        double salaireBaseAnaovanaCalcule = 0.0;
        if (salaire != ""  && !salaire.isBlank()) {                        // raha nanome salaire de base izy
            salaireBaseAnaovanaCalcule = Double.parseDouble(salaire);
        } else if ("on".equals(moyenne)) {          // raha coche lay moyenne
            double moyenneSalaryBase = calculateAverageBaseSalary(date_debut);
            System.out.println("moyenne salaire de base : " + salaireBaseAnaovanaCalcule);
            if (moyenneSalaryBase > 0) {
                salaireBaseAnaovanaCalcule = moyenneSalaryBase;
            } else {
                return "il n'y a pas de salary structure assignement trouver pour faire moyenne salaire de base";
            }
        } else {
            AssignmentHR assignmentRecent = getLastAssignmentByEmployeeBeforeDate(employeeId,date_debut);
            if (assignmentRecent != null) {
                salaireBaseAnaovanaCalcule = assignmentRecent.getBase();
            } else {
                return "il n'y a pas de salary structure assignement trouver , veuiller entre une salaire de base";
            }
        }

        for (YearMonth ym : yearMonth) {
            LocalDate fromDate = ym.atDay(1);
            LocalDate toDate = ym.atEndOfMonth();

            // ===== verification et creation salary structure assignements ===== //
            AssignmentHR salaryStructureAssignmentHR = new AssignmentHR();
            salaryStructureAssignmentHR.setEmployee(employeeHR.getEmployee());
            salaryStructureAssignmentHR.setSalary_structure(getOneSalaryStructure().getName());
            salaryStructureAssignmentHR.setCompany(getOneCompany().getName());
            salaryStructureAssignmentHR.setFrom_date(fromDate.toString());
            salaryStructureAssignmentHR.setBase(salaireBaseAnaovanaCalcule);

            // ===== verification et creation salary slip ===== //
            SalarySlipHR salarySlipHR = new SalarySlipHR();
            salarySlipHR.setEmployee(employeeHR.getEmployee());
            salarySlipHR.setPayroll_frequency("Monthly");
            salarySlipHR.setStart_date(fromDate.toString());
            salarySlipHR.setEnd_date(toDate.toString());
            List<SalarySlipHR> salarySlipExiste = getSalarySlipsByEmployeeAndPeriod(employeeId,fromDate.toString(),toDate.toString());
            if (salarySlipExiste == null) {
                deleteSalaryStructureAssignment(employeeId, fromDate.toString(), toDate.toString());
                createSalaryStructureAssignment(salaryStructureAssignmentHR);
                createSalarySlip(salarySlipHR);
            } else if ("on".equals(ecrase)) {
                for (SalarySlipHR salarySlip : salarySlipExiste) {
                    deleteSalarySlipByName(salarySlip.getName());
                }
                deleteSalaryStructureAssignment(employeeId, fromDate.toString(), toDate.toString());
                createSalaryStructureAssignment(salaryStructureAssignmentHR);
                createSalarySlip(salarySlipHR);
            }
        }
        
        return "Salary Slip genere avec succès !";
    }

    public void modificationSalaireBase (
            String salaryComponentName,
            String condition,
            String montant,
            String nouvelleSalaireBase,
            String pourcentage
            ) throws Exception {

        List<SalarySlipHR> salarySlipFiltrer = filterSalarySlipByComponent(salaryComponentName, condition, Double.parseDouble(montant));

        if (!salarySlipFiltrer.isEmpty()) {
            setEarningsAndDeductionsSalarySlip(salarySlipFiltrer);
            for (SalarySlipHR ancienSalarySlip : salarySlipFiltrer) {
                double newSalareBase = 0;
                if (pourcentage != ""  && !pourcentage.isBlank()) {
                    newSalareBase = ((ancienSalarySlip.getEarningsAndDeductions().get("Salaire Base") * Double.parseDouble(pourcentage)) / 100) + Double.parseDouble(nouvelleSalaireBase);
                } else {
                    newSalareBase = Double.parseDouble(nouvelleSalaireBase);
                }

                AssignmentHR newSalaryStructureAssignment = new AssignmentHR();
                newSalaryStructureAssignment.setEmployee(ancienSalarySlip.getEmployee());
                newSalaryStructureAssignment.setSalary_structure(ancienSalarySlip.getSalary_structure());
                newSalaryStructureAssignment.setCompany(ancienSalarySlip.getCompany());
                newSalaryStructureAssignment.setFrom_date(ancienSalarySlip.getStart_date());
                newSalaryStructureAssignment.setBase(newSalareBase);

                SalarySlipHR newSalarySlip = new SalarySlipHR();
                newSalarySlip.setEmployee(ancienSalarySlip.getEmployee());
                newSalarySlip.setPayroll_frequency("Monthly");
                newSalarySlip.setStart_date(ancienSalarySlip.getStart_date());
                newSalarySlip.setEnd_date(ancienSalarySlip.getEnd_date());

                HistoriqueSalarySlip historiqueSalarySlip = new HistoriqueSalarySlip();
                historiqueSalarySlip.setName(ancienSalarySlip.getName());
                historiqueSalarySlip.setEmployee_name(ancienSalarySlip.getEmployee_name());
                historiqueSalarySlip.setSalary_structure(ancienSalarySlip.getSalary_structure());
                historiqueSalarySlip.setStart_date(ancienSalarySlip.getStart_date());
                historiqueSalarySlip.setEnd_date(ancienSalarySlip.getEnd_date());
                historiqueSalarySlip.setSalaire_de_base(ancienSalarySlip.getEarningsAndDeductions().get("Salaire Base").toString());

                historiqueSalarySlipService.save(historiqueSalarySlip);

                deleteSalarySlipByName(ancienSalarySlip.getName());
                deleteSalaryStructureAssignment(ancienSalarySlip.getEmployee(), ancienSalarySlip.getStart_date(), ancienSalarySlip.getEnd_date());

                createSalaryStructureAssignment(newSalaryStructureAssignment);
                createSalarySlip(newSalarySlip);
            }
        }
    }

    public Map<String,String> listDate (String year) {
        Map<String,String> listDate = new HashMap<>();
        listDate.put("Janvier",year + "-01-15");
        listDate.put("Fevrier",year + "-02-15");
        listDate.put("Mars",year + "-03-15");
        listDate.put("Avril",year + "-04-15");
        listDate.put("Mai",year + "-05-15");
        listDate.put("Juin",year + "-06-15");
        listDate.put("Juillet",year + "-07-15");
        listDate.put("Aout",year + "-08-15");
        listDate.put("Septembre",year + "-09-15");
        listDate.put("Octobre",year + "-10-15");
        listDate.put("Novembre",year + "-11-15");
        listDate.put("Decembre",year + "-12-15");
        return listDate;
    }

    public List<YearMonth> getMonthlyPeriods(LocalDate startDate, LocalDate endDate) {
        
        List<YearMonth> months = new ArrayList<>();

        YearMonth start = YearMonth.from(startDate);
        YearMonth end = YearMonth.from(endDate);

        while (!start.isAfter(end)) {
            months.add(start);
            start = start.plusMonths(1);
        }

        return months;
    }

}

   // public List<SalarySlipHR> rechercheSalaireEtEmployee (
    //         String salaryComponentName,
    //         String condition,
    //         String montant) throws Exception {
        
    //     List<SalarySlipHR> salarySlipFiltrer = filterSalarySlipByComponent(salaryComponentName, condition, Double.parseDouble(montant));

    //     if (!salarySlipFiltrer.isEmpty()) {
    //         setEarningsAndDeductionsSalarySlip(salarySlipFiltrer);
    //     }

    //     return salarySlipFiltrer;
    // }