package com.example.ERPNext.entity.frappeHR;

import jakarta.persistence.*;

@Entity
@Table(name = "historique_salary_slip")
public class HistoriqueSalarySlip {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name" , length = 255 ,nullable = false)
    private String name;

    @Column(name = "employee_name" , length = 255 ,nullable = false)
    private String employee_name;

    @Column(name = "salary_structure" , length = 255 ,nullable = false)
    private String salary_structure;

    @Column(name = "start_date" , length = 255 ,nullable = false)
    private String start_date;

    @Column(name = "end_date" , length = 255 ,nullable = false)
    private String end_date;

    @Column(name = "salaire_de_base" , length = 255 ,nullable = false)
    private String salaire_de_base;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getSalary_structure() {
        return salary_structure;
    }

    public void setSalary_structure(String salary_structure) {
        this.salary_structure = salary_structure;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getSalaire_de_base() {
        return salaire_de_base;
    }

    public void setSalaire_de_base(String salaire_de_base) {
        this.salaire_de_base = salaire_de_base;
    }
}
