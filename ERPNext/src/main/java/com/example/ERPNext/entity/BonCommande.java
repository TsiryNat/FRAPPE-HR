package com.example.ERPNext.entity;

public class BonCommande {
    
    private String supplier;
    private String status;
    private String transaction_date;
    private double pourc_billed;
    private double pourc_received;
    private String grand_total;
    private String name;

    public BonCommande(String supplier, String status, String transaction_date, double pourc_billed,
            double pourc_received, String grand_total, String name) {
        this.supplier = supplier;
        this.status = status;
        this.transaction_date = transaction_date;
        this.pourc_billed = pourc_billed;
        this.pourc_received = pourc_received;
        this.grand_total = grand_total;
        this.name = name;
    }
    
    public double getPourc_billed() {
        return pourc_billed;
    }
    public void setPourc_billed(double pourc_billed) {
        this.pourc_billed = pourc_billed;
    }
    public double getPourc_received() {
        return pourc_received;
    }
    public void setPourc_received(double pourc_received) {
        this.pourc_received = pourc_received;
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
    public String getTransaction_date() {
        return transaction_date;
    }
    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
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
