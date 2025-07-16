package com.example.ERPNext.entity.frappeHR;

import java.util.Map;

public class EmployeAndSalaryComponent {
    
    public AssignmentHR assignment ;
    public SalaryStructureHR salaryStructure ;
    public Map<String, Double> earningsAndDeductions;

    public EmployeAndSalaryComponent() {
    }

    public EmployeAndSalaryComponent(AssignmentHR assignment, SalaryStructureHR salaryStructure) {
        this.assignment = assignment;
        this.salaryStructure = salaryStructure;
    }

    public AssignmentHR getAssignment() {
        return assignment;
    }
    public void setAssignment(AssignmentHR assignment) {
        this.assignment = assignment;
    }
    public SalaryStructureHR getSalaryStructure() {
        return salaryStructure;
    }
    public void setSalaryStructure(SalaryStructureHR salaryStructure) {
        this.salaryStructure = salaryStructure;
    }

    public Map<String, Double> getEarningsAndDeductions() {
        return earningsAndDeductions;
    }

    public void setEarningsAndDeductions(Map<String, Double> earningsAndDeductions) {
        this.earningsAndDeductions = earningsAndDeductions;
    }
    
}
