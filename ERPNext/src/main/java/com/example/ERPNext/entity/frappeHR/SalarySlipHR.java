package com.example.ERPNext.entity.frappeHR;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalarySlipHR {

    public String name;
	public String creation;
	public String modified;
	public String modified_by;
	public String owner;
	public int docstatus;
	public int idx;
	public String employee;
	public String employee_name;
	public String company;
	public String department;
	public String designation;
	public String branch;
	public String posting_date;
	public String letter_head;
	public String status;
	public String salary_withholding;
	public String salary_withholding_cycle;
	public String currency;
	public double exchange_rate;
	public String payroll_frequency;
	public String start_date;
	public String end_date;
	public String salary_structure;
	public String payroll_entry;
	public String mode_of_payment;
	public int salary_slip_based_on_timesheet;
	public int deduct_tax_for_unclaimed_employee_benefits;
	public int deduct_tax_for_unsubmitted_tax_exemption_proof;
	public double total_working_days;
	public double unmarked_days;
	public double leave_without_pay;
	public double absent_days;
	public double payment_days;
	public double total_working_hours;
	public double hour_rate;
	public double base_hour_rate;
	public double gross_pay;
	public double base_gross_pay;
	public double gross_year_to_date;
	public double base_gross_year_to_date;
	public double total_deduction;
	public double base_total_deduction;
	public double net_pay;
	public double base_net_pay;
	public double rounded_total;
	public double base_rounded_total;
	public double year_to_date;
	public double base_year_to_date;
	public double month_to_date;
	public double base_month_to_date;
	public String total_in_words;
	public String base_total_in_words;
	public double ctc;
	public double income_from_other_sources;
	public double total_earnings;
	public double non_taxable_earnings;
	public double standard_tax_exemption_amount;
	public double tax_exemption_declaration;
	public double deductions_before_tax_calculation;
	public double annual_taxable_amount;
	public double income_tax_deducted_till_date;
	public double current_month_income_tax;
	public double future_income_tax_deductions;
	public double total_income_tax;
	public String journal_entry;
	public String amended_from;
	public String bank_name;
	public String bank_account_no;
	public String user_tags;
	public String comments;
	public String assign;
	public String liked_by;

    public List<SalaryComponentHR> earnings;
    public List<SalaryComponentHR> deductions;
    public Map<String, Double> earningsAndDeductions;

    public SalarySlipHR() {
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
    public String getEmployee() {
        return employee;
    }
    public void setEmployee(String employee) {
        this.employee = employee;
    }
    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getPosting_date() {
        return posting_date;
    }
    public void setPosting_date(String posting_date) {
        this.posting_date = posting_date;
    }
    public String getLetter_head() {
        return letter_head;
    }
    public void setLetter_head(String letter_head) {
        this.letter_head = letter_head;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSalary_withholding() {
        return salary_withholding;
    }
    public void setSalary_withholding(String salary_withholding) {
        this.salary_withholding = salary_withholding;
    }
    public String getSalary_withholding_cycle() {
        return salary_withholding_cycle;
    }
    public void setSalary_withholding_cycle(String salary_withholding_cycle) {
        this.salary_withholding_cycle = salary_withholding_cycle;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public double getExchange_rate() {
        return exchange_rate;
    }
    public void setExchange_rate(double exchange_rate) {
        this.exchange_rate = exchange_rate;
    }
    public String getPayroll_frequency() {
        return payroll_frequency;
    }
    public void setPayroll_frequency(String payroll_frequency) {
        this.payroll_frequency = payroll_frequency;
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
    public String getSalary_structure() {
        return salary_structure;
    }
    public void setSalary_structure(String salary_structure) {
        this.salary_structure = salary_structure;
    }
    public String getPayroll_entry() {
        return payroll_entry;
    }
    public void setPayroll_entry(String payroll_entry) {
        this.payroll_entry = payroll_entry;
    }
    public String getMode_of_payment() {
        return mode_of_payment;
    }
    public void setMode_of_payment(String mode_of_payment) {
        this.mode_of_payment = mode_of_payment;
    }
    public int getSalary_slip_based_on_timesheet() {
        return salary_slip_based_on_timesheet;
    }
    public void setSalary_slip_based_on_timesheet(int salary_slip_based_on_timesheet) {
        this.salary_slip_based_on_timesheet = salary_slip_based_on_timesheet;
    }
    public int getDeduct_tax_for_unclaimed_employee_benefits() {
        return deduct_tax_for_unclaimed_employee_benefits;
    }
    public void setDeduct_tax_for_unclaimed_employee_benefits(int deduct_tax_for_unclaimed_employee_benefits) {
        this.deduct_tax_for_unclaimed_employee_benefits = deduct_tax_for_unclaimed_employee_benefits;
    }
    public int getDeduct_tax_for_unsubmitted_tax_exemption_proof() {
        return deduct_tax_for_unsubmitted_tax_exemption_proof;
    }
    public void setDeduct_tax_for_unsubmitted_tax_exemption_proof(int deduct_tax_for_unsubmitted_tax_exemption_proof) {
        this.deduct_tax_for_unsubmitted_tax_exemption_proof = deduct_tax_for_unsubmitted_tax_exemption_proof;
    }
    public double getTotal_working_days() {
        return total_working_days;
    }
    public void setTotal_working_days(double total_working_days) {
        this.total_working_days = total_working_days;
    }
    public double getUnmarked_days() {
        return unmarked_days;
    }
    public void setUnmarked_days(double unmarked_days) {
        this.unmarked_days = unmarked_days;
    }
    public double getLeave_without_pay() {
        return leave_without_pay;
    }
    public void setLeave_without_pay(double leave_without_pay) {
        this.leave_without_pay = leave_without_pay;
    }
    public double getAbsent_days() {
        return absent_days;
    }
    public void setAbsent_days(double absent_days) {
        this.absent_days = absent_days;
    }
    public double getPayment_days() {
        return payment_days;
    }
    public void setPayment_days(double payment_days) {
        this.payment_days = payment_days;
    }
    public double getTotal_working_hours() {
        return total_working_hours;
    }
    public void setTotal_working_hours(double total_working_hours) {
        this.total_working_hours = total_working_hours;
    }
    public double getHour_rate() {
        return hour_rate;
    }
    public void setHour_rate(double hour_rate) {
        this.hour_rate = hour_rate;
    }
    public double getBase_hour_rate() {
        return base_hour_rate;
    }
    public void setBase_hour_rate(double base_hour_rate) {
        this.base_hour_rate = base_hour_rate;
    }
    public double getGross_pay() {
        return gross_pay;
    }
    public void setGross_pay(double gross_pay) {
        this.gross_pay = gross_pay;
    }
    public double getBase_gross_pay() {
        return base_gross_pay;
    }
    public void setBase_gross_pay(double base_gross_pay) {
        this.base_gross_pay = base_gross_pay;
    }
    public double getGross_year_to_date() {
        return gross_year_to_date;
    }
    public void setGross_year_to_date(double gross_year_to_date) {
        this.gross_year_to_date = gross_year_to_date;
    }
    public double getBase_gross_year_to_date() {
        return base_gross_year_to_date;
    }
    public void setBase_gross_year_to_date(double base_gross_year_to_date) {
        this.base_gross_year_to_date = base_gross_year_to_date;
    }
    public double getTotal_deduction() {
        return total_deduction;
    }
    public void setTotal_deduction(double total_deduction) {
        this.total_deduction = total_deduction;
    }
    public double getBase_total_deduction() {
        return base_total_deduction;
    }
    public void setBase_total_deduction(double base_total_deduction) {
        this.base_total_deduction = base_total_deduction;
    }
    public double getNet_pay() {
        return net_pay;
    }
    public void setNet_pay(double net_pay) {
        this.net_pay = net_pay;
    }
    public double getBase_net_pay() {
        return base_net_pay;
    }
    public void setBase_net_pay(double base_net_pay) {
        this.base_net_pay = base_net_pay;
    }
    public double getRounded_total() {
        return rounded_total;
    }
    public void setRounded_total(double rounded_total) {
        this.rounded_total = rounded_total;
    }
    public double getBase_rounded_total() {
        return base_rounded_total;
    }
    public void setBase_rounded_total(double base_rounded_total) {
        this.base_rounded_total = base_rounded_total;
    }
    public double getYear_to_date() {
        return year_to_date;
    }
    public void setYear_to_date(double year_to_date) {
        this.year_to_date = year_to_date;
    }
    public double getBase_year_to_date() {
        return base_year_to_date;
    }
    public void setBase_year_to_date(double base_year_to_date) {
        this.base_year_to_date = base_year_to_date;
    }
    public double getMonth_to_date() {
        return month_to_date;
    }
    public void setMonth_to_date(double month_to_date) {
        this.month_to_date = month_to_date;
    }
    public double getBase_month_to_date() {
        return base_month_to_date;
    }
    public void setBase_month_to_date(double base_month_to_date) {
        this.base_month_to_date = base_month_to_date;
    }
    public String getTotal_in_words() {
        return total_in_words;
    }
    public void setTotal_in_words(String total_in_words) {
        this.total_in_words = total_in_words;
    }
    public String getBase_total_in_words() {
        return base_total_in_words;
    }
    public void setBase_total_in_words(String base_total_in_words) {
        this.base_total_in_words = base_total_in_words;
    }
    public double getCtc() {
        return ctc;
    }
    public void setCtc(double ctc) {
        this.ctc = ctc;
    }
    public double getIncome_from_other_sources() {
        return income_from_other_sources;
    }
    public void setIncome_from_other_sources(double income_from_other_sources) {
        this.income_from_other_sources = income_from_other_sources;
    }
    public double getTotal_earnings() {
        return total_earnings;
    }
    public void setTotal_earnings(double total_earnings) {
        this.total_earnings = total_earnings;
    }
    public double getNon_taxable_earnings() {
        return non_taxable_earnings;
    }
    public void setNon_taxable_earnings(double non_taxable_earnings) {
        this.non_taxable_earnings = non_taxable_earnings;
    }
    public double getStandard_tax_exemption_amount() {
        return standard_tax_exemption_amount;
    }
    public void setStandard_tax_exemption_amount(double standard_tax_exemption_amount) {
        this.standard_tax_exemption_amount = standard_tax_exemption_amount;
    }
    public double getTax_exemption_declaration() {
        return tax_exemption_declaration;
    }
    public void setTax_exemption_declaration(double tax_exemption_declaration) {
        this.tax_exemption_declaration = tax_exemption_declaration;
    }
    public double getDeductions_before_tax_calculation() {
        return deductions_before_tax_calculation;
    }
    public void setDeductions_before_tax_calculation(double deductions_before_tax_calculation) {
        this.deductions_before_tax_calculation = deductions_before_tax_calculation;
    }
    public double getAnnual_taxable_amount() {
        return annual_taxable_amount;
    }
    public void setAnnual_taxable_amount(double annual_taxable_amount) {
        this.annual_taxable_amount = annual_taxable_amount;
    }
    public double getIncome_tax_deducted_till_date() {
        return income_tax_deducted_till_date;
    }
    public void setIncome_tax_deducted_till_date(double income_tax_deducted_till_date) {
        this.income_tax_deducted_till_date = income_tax_deducted_till_date;
    }
    public double getCurrent_month_income_tax() {
        return current_month_income_tax;
    }
    public void setCurrent_month_income_tax(double current_month_income_tax) {
        this.current_month_income_tax = current_month_income_tax;
    }
    public double getFuture_income_tax_deductions() {
        return future_income_tax_deductions;
    }
    public void setFuture_income_tax_deductions(double future_income_tax_deductions) {
        this.future_income_tax_deductions = future_income_tax_deductions;
    }
    public double getTotal_income_tax() {
        return total_income_tax;
    }
    public void setTotal_income_tax(double total_income_tax) {
        this.total_income_tax = total_income_tax;
    }
    public String getJournal_entry() {
        return journal_entry;
    }
    public void setJournal_entry(String journal_entry) {
        this.journal_entry = journal_entry;
    }
    public String getAmended_from() {
        return amended_from;
    }
    public void setAmended_from(String amended_from) {
        this.amended_from = amended_from;
    }
    public String getBank_name() {
        return bank_name;
    }
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
    public String getBank_account_no() {
        return bank_account_no;
    }
    public void setBank_account_no(String bank_account_no) {
        this.bank_account_no = bank_account_no;
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

    public Map<String, Double> getEarningsAndDeductions() {
        return earningsAndDeductions;
    }

    public void setEarningsAndDeductions(Map<String, Double> earningsAndDeductions) {
        this.earningsAndDeductions = earningsAndDeductions;
    }

}
