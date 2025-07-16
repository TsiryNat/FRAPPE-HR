package com.example.ERPNext.entity;

public class DevisItem {
    
    private String itemCode;
    private String name;
    private String description;
    private int qty;
    private double rate;

    public DevisItem(String itemCode, String name, String description, int qty, double rate) {
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.qty = qty;
        this.rate = rate;
    }
    
    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
