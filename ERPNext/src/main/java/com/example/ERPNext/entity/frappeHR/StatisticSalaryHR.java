package com.example.ERPNext.entity.frappeHR;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticSalaryHR {
    
    public List<EmployeAndSalaryComponent> employeAndSalaryComponents;
    public String mois;
    public String date;
    public double totalBase;
    public Map<String,Double> totalEarningAndDeduction;

    public StatisticSalaryHR(List<EmployeAndSalaryComponent> employeAndSalaryComponents,String mois,String date) {
        this.employeAndSalaryComponents = employeAndSalaryComponents;
        this.totalBase = 0;
        this.totalEarningAndDeduction = new HashMap<>();
        this.mois = mois;
        this.date = date;
        for (EmployeAndSalaryComponent employeAndSalaryComponent : employeAndSalaryComponents) {
            this.totalBase += employeAndSalaryComponent.getAssignment().getBase();
            for (Map.Entry<String, Double> earningAndDeduction : employeAndSalaryComponent.getEarningsAndDeductions().entrySet()) {
                if (totalEarningAndDeduction.containsKey(earningAndDeduction.getKey())) {
                    totalEarningAndDeduction.put(earningAndDeduction.getKey(), ( totalEarningAndDeduction.get(earningAndDeduction.getKey()) + earningAndDeduction.getValue() ) );
                } else {
                    totalEarningAndDeduction.put(earningAndDeduction.getKey(), earningAndDeduction.getValue());
                }
            }
        }
    }

    public List<EmployeAndSalaryComponent> getEmployeAndSalaryComponents() {
        return employeAndSalaryComponents;
    }
    public void setEmployeAndSalaryComponents(List<EmployeAndSalaryComponent> employeAndSalaryComponents) {
        this.employeAndSalaryComponents = employeAndSalaryComponents;
    }
    public double getTotalBase() {
        return totalBase;
    }
    public void setTotalBase(double totalBase) {
        this.totalBase = totalBase;
    }
    public Map<String, Double> getTotalEarningAndDeduction() {
        return totalEarningAndDeduction;
    }
    public void setTotalEarningAndDeduction(Map<String, Double> totalEarningAndDeduction) {
        this.totalEarningAndDeduction = totalEarningAndDeduction;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

// for (Map.Entry<String, Double> entry : map.entrySet()) {
//     System.out.println("map put " + entry.getKey() + " : " + entry.getValue());
// }