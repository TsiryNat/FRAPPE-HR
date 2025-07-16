package com.example.ERPNext.entity;

public class Facture {

    private String supplier ;
    private String status  ;
    private String posting_date  ;
    private String grand_total ;
    private String name ;

    public Facture(String supplier, String status, String posting_date, String grand_total, String name) {
        this.supplier = supplier;
        this.status = status;
        this.posting_date = posting_date;
        this.grand_total = grand_total;
        this.name = name;
    }
    
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPosting_date() {
        return posting_date;
    }
    public void setPosting_date(String posting_date) {
        this.posting_date = posting_date;
    }
    public String getGrand_total() {
        return grand_total;
    }
    public void setGrand_total(String grand_total) {
        this.grand_total = grand_total;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
