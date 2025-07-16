package com.example.ERPNext.entity;

public class DemandeDevis {
    
    private String name;
    private String transaction_date;
    private String status;
    private String supplier;
    private String total;
    private String currency;
    
    public DemandeDevis(String name, String transaction_date, String status, String supplier, String total,
            String currency) {
        this.name = name;
        this.transaction_date = transaction_date;
        this.status = status;
        this.supplier = supplier;
        this.total = total;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTransaction_date() {
        return transaction_date;
    }
    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
}
