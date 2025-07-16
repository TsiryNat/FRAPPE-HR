package com.example.ERPNext.entity.frappeHR;

import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(ignoreUnknown = true)
public class SalaryStructureHR {
    
    public String name;
	public String creation;
	public String modified;
	public String modified_by;
	public String owner;
	public int docstatus;
	public int idx;
	public String company;
	public String letter_head;
	public String is_active;
	public String is_default;
	public String currency;
	public String amended_from;
	public double leave_encashment_amount_per_day;
	public double max_benefits;
	public int salary_slip_based_on_timesheet;
	public String payroll_frequency;
	public String salary_component;
	public double hour_rate;
	public double total_earning;
	public double total_deduction;
	public double net_pay;
	public String mode_of_payment;
	public String payment_account;
	public String user_tags;
	public String comments;
	public String assign;
	public String liked_by;
	public String doctype;

    public List<SalaryComponentHR> earnings;
    public List<SalaryComponentHR> deductions;

    public SalaryStructureHR() { 
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCreation() {
        return creation;
    }
    public void setCreation(String creation) {
        this.creation = creation;
    }
    public String getModified() {
        return modified;
    }
    public void setModified(String modified) {
        this.modified = modified;
    }
    public String getModified_by() {
        return modified_by;
    }
    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public int getDocstatus() {
        return docstatus;
    }
    public void setDocstatus(int docstatus) {
        this.docstatus = docstatus;
    }
    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLetter_head() {
        return letter_head;
    }
    public void setLetter_head(String letter_head) {
        this.letter_head = letter_head;
    }
    public String getIs_active() {
        return is_active;
    }
    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }
    public String getIs_default() {
        return is_default;
    }
    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getAmended_from() {
        return amended_from;
    }
    public void setAmended_from(String amended_from) {
        this.amended_from = amended_from;
    }
    public double getLeave_encashment_amount_per_day() {
        return leave_encashment_amount_per_day;
    }
    public void setLeave_encashment_amount_per_day(double leave_encashment_amount_per_day) {
        this.leave_encashment_amount_per_day = leave_encashment_amount_per_day;
    }
    public double getMax_benefits() {
        return max_benefits;
    }
    public void setMax_benefits(double max_benefits) {
        this.max_benefits = max_benefits;
    }
    public int getSalary_slip_based_on_timesheet() {
        return salary_slip_based_on_timesheet;
    }
    public void setSalary_slip_based_on_timesheet(int salary_slip_based_on_timesheet) {
        this.salary_slip_based_on_timesheet = salary_slip_based_on_timesheet;
    }
    public String getPayroll_frequency() {
        return payroll_frequency;
    }
    public void setPayroll_frequency(String payroll_frequency) {
        this.payroll_frequency = payroll_frequency;
    }
    public String getSalary_component() {
        return salary_component;
    }
    public void setSalary_component(String salary_component) {
        this.salary_component = salary_component;
    }
    public double getHour_rate() {
        return hour_rate;
    }
    public void setHour_rate(double hour_rate) {
        this.hour_rate = hour_rate;
    }
    public double getTotal_earning() {
        return total_earning;
    }
    public void setTotal_earning(double total_earning) {
        this.total_earning = total_earning;
    }
    public double getTotal_deduction() {
        return total_deduction;
    }
    public void setTotal_deduction(double total_deduction) {
        this.total_deduction = total_deduction;
    }
    public double getNet_pay() {
        return net_pay;
    }
    public void setNet_pay(double net_pay) {
        this.net_pay = net_pay;
    }
    public String getMode_of_payment() {
        return mode_of_payment;
    }
    public void setMode_of_payment(String mode_of_payment) {
        this.mode_of_payment = mode_of_payment;
    }
    public String getPayment_account() {
        return payment_account;
    }
    public void setPayment_account(String payment_account) {
        this.payment_account = payment_account;
    }
    public String getUser_tags() {
        return user_tags;
    }
    public void setUser_tags(String user_tags) {
        this.user_tags = user_tags;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getAssign() {
        return assign;
    }
    public void setAssign(String assign) {
        this.assign = assign;
    }
    public String getLiked_by() {
        return liked_by;
    }
    public void setLiked_by(String liked_by) {
        this.liked_by = liked_by;
    }
    public List<SalaryComponentHR> getEarnings() {
        return earnings;
    }
    public void setEarnings(List<SalaryComponentHR> earnings) {
        this.earnings = earnings;
    }
    public List<SalaryComponentHR> getDeductions() {
        return deductions;
    }
    public void setDeductions(List<SalaryComponentHR> deductions) {
        this.deductions = deductions;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }
}
