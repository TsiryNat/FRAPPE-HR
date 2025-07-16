package com.example.ERPNext.entity.frappeHR;

public class CompanyHR {
    
    public String name;
	public String creation;
	public String modified;
	public String modified_by;
	public String owner;
	public int docstatus;
	public int idx;
	public String company_name;
	public String abbr;
	public String default_currency;
	public String country;
	public int is_group;
	public String default_holiday_list;
	public String default_letter_head;
	public String tax_id;
	public String domain;
	public String date_of_establishment;
	public String parent_company;
	public String company_logo;
	public String date_of_incorporation;
	public String phone_no;
	public String email;
	public String company_description;
	public String date_of_commencement;
	public String fax;
	public String website;
	public String registration_details;
	public int lft;
	public int rgt;
	public String old_parent;
	public String create_chart_of_accounts_based_on;
	public String existing_company;
	public String chart_of_accounts;
	public String default_bank_account;
	public String default_cash_account;
	public String default_receivable_account;
	public String default_payable_account;
	public String write_off_account;
	public String unrealized_profit_loss_account;
	public int allow_account_creation_against_child_company;
	public String default_expense_account;
	public String default_income_account;
	public String default_discount_account;
	public String payment_terms;
	public String cost_center;
	public String default_finance_book;
	public String exchange_gain_loss_account;
	public String unrealized_exchange_gain_loss_account;
	public String round_off_account;
	public String round_off_cost_center;
	public String round_off_for_opening;
	public String default_deferred_revenue_account;
	public String default_deferred_expense_account;
	public int book_advance_payments_in_separate_party_account;
	public int reconcile_on_advance_payment_date;
	public String reconciliation_takes_effect_on;
	public String default_advance_received_account;
	public String default_advance_paid_account;
	public int auto_exchange_rate_revaluation;
	public String auto_err_frequency;
	public int submit_err_jv;
	public String exception_budget_approver_role;
	public String accumulated_depreciation_account;
	public String depreciation_expense_account;
	public String series_for_depreciation_entry;
	public String disposal_account;
	public String depreciation_cost_center;
	public String capital_work_in_progress_account;
	public String asset_received_but_not_billed;
	public String default_buying_terms;
	public String sales_monthly_history;
	public double monthly_sales_target;
	public double total_monthly_sales;
	public String default_selling_terms;
	public String default_warehouse_for_sales_return;
	public double credit_limit;
	public String transactions_annual_history;
	public int enable_perpetual_inventory;
	public int enable_provisional_accounting_for_non_stock_items;
	public String default_inventory_account;
	public String stock_adjustment_account;
	public String stock_received_but_not_billed;
	public String default_provisional_account;
	public String default_in_transit_warehouse;
	public String default_operating_cost_account;
	public String _user_tags;
	public String _comments;
	public String _assign;
	public String _liked_by;
	public String default_expense_claim_payable_account;
	public String default_employee_advance_account;
	public String default_payroll_payable_account;
    
    public CompanyHR() {
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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getDefault_currency() {
        return default_currency;
    }

    public void setDefault_currency(String default_currency) {
        this.default_currency = default_currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getIs_group() {
        return is_group;
    }

    public void setIs_group(int is_group) {
        this.is_group = is_group;
    }

    public String getDefault_holiday_list() {
        return default_holiday_list;
    }

    public void setDefault_holiday_list(String default_holiday_list) {
        this.default_holiday_list = default_holiday_list;
    }

    public String getDefault_letter_head() {
        return default_letter_head;
    }

    public void setDefault_letter_head(String default_letter_head) {
        this.default_letter_head = default_letter_head;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDate_of_establishment() {
        return date_of_establishment;
    }

    public void setDate_of_establishment(String date_of_establishment) {
        this.date_of_establishment = date_of_establishment;
    }

    public String getParent_company() {
        return parent_company;
    }

    public void setParent_company(String parent_company) {
        this.parent_company = parent_company;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getDate_of_incorporation() {
        return date_of_incorporation;
    }

    public void setDate_of_incorporation(String date_of_incorporation) {
        this.date_of_incorporation = date_of_incorporation;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany_description() {
        return company_description;
    }

    public void setCompany_description(String company_description) {
        this.company_description = company_description;
    }

    public String getDate_of_commencement() {
        return date_of_commencement;
    }

    public void setDate_of_commencement(String date_of_commencement) {
        this.date_of_commencement = date_of_commencement;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRegistration_details() {
        return registration_details;
    }

    public void setRegistration_details(String registration_details) {
        this.registration_details = registration_details;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRgt() {
        return rgt;
    }

    public void setRgt(int rgt) {
        this.rgt = rgt;
    }

    public String getOld_parent() {
        return old_parent;
    }

    public void setOld_parent(String old_parent) {
        this.old_parent = old_parent;
    }

    public String getCreate_chart_of_accounts_based_on() {
        return create_chart_of_accounts_based_on;
    }

    public void setCreate_chart_of_accounts_based_on(String create_chart_of_accounts_based_on) {
        this.create_chart_of_accounts_based_on = create_chart_of_accounts_based_on;
    }

    public String getExisting_company() {
        return existing_company;
    }

    public void setExisting_company(String existing_company) {
        this.existing_company = existing_company;
    }

    public String getChart_of_accounts() {
        return chart_of_accounts;
    }

    public void setChart_of_accounts(String chart_of_accounts) {
        this.chart_of_accounts = chart_of_accounts;
    }

    public String getDefault_bank_account() {
        return default_bank_account;
    }

    public void setDefault_bank_account(String default_bank_account) {
        this.default_bank_account = default_bank_account;
    }

    public String getDefault_cash_account() {
        return default_cash_account;
    }

    public void setDefault_cash_account(String default_cash_account) {
        this.default_cash_account = default_cash_account;
    }

    public String getDefault_receivable_account() {
        return default_receivable_account;
    }

    public void setDefault_receivable_account(String default_receivable_account) {
        this.default_receivable_account = default_receivable_account;
    }

    public String getDefault_payable_account() {
        return default_payable_account;
    }

    public void setDefault_payable_account(String default_payable_account) {
        this.default_payable_account = default_payable_account;
    }

    public String getWrite_off_account() {
        return write_off_account;
    }

    public void setWrite_off_account(String write_off_account) {
        this.write_off_account = write_off_account;
    }

    public String getUnrealized_profit_loss_account() {
        return unrealized_profit_loss_account;
    }

    public void setUnrealized_profit_loss_account(String unrealized_profit_loss_account) {
        this.unrealized_profit_loss_account = unrealized_profit_loss_account;
    }

    public int getAllow_account_creation_against_child_company() {
        return allow_account_creation_against_child_company;
    }

    public void setAllow_account_creation_against_child_company(int allow_account_creation_against_child_company) {
        this.allow_account_creation_against_child_company = allow_account_creation_against_child_company;
    }

    public String getDefault_expense_account() {
        return default_expense_account;
    }

    public void setDefault_expense_account(String default_expense_account) {
        this.default_expense_account = default_expense_account;
    }

    public String getDefault_income_account() {
        return default_income_account;
    }

    public void setDefault_income_account(String default_income_account) {
        this.default_income_account = default_income_account;
    }

    public String getDefault_discount_account() {
        return default_discount_account;
    }

    public void setDefault_discount_account(String default_discount_account) {
        this.default_discount_account = default_discount_account;
    }

    public String getPayment_terms() {
        return payment_terms;
    }

    public void setPayment_terms(String payment_terms) {
        this.payment_terms = payment_terms;
    }

    public String getCost_center() {
        return cost_center;
    }

    public void setCost_center(String cost_center) {
        this.cost_center = cost_center;
    }

    public String getDefault_finance_book() {
        return default_finance_book;
    }

    public void setDefault_finance_book(String default_finance_book) {
        this.default_finance_book = default_finance_book;
    }

    public String getExchange_gain_loss_account() {
        return exchange_gain_loss_account;
    }

    public void setExchange_gain_loss_account(String exchange_gain_loss_account) {
        this.exchange_gain_loss_account = exchange_gain_loss_account;
    }

    public String getUnrealized_exchange_gain_loss_account() {
        return unrealized_exchange_gain_loss_account;
    }

    public void setUnrealized_exchange_gain_loss_account(String unrealized_exchange_gain_loss_account) {
        this.unrealized_exchange_gain_loss_account = unrealized_exchange_gain_loss_account;
    }

    public String getRound_off_account() {
        return round_off_account;
    }

    public void setRound_off_account(String round_off_account) {
        this.round_off_account = round_off_account;
    }

    public String getRound_off_cost_center() {
        return round_off_cost_center;
    }

    public void setRound_off_cost_center(String round_off_cost_center) {
        this.round_off_cost_center = round_off_cost_center;
    }

    public String getRound_off_for_opening() {
        return round_off_for_opening;
    }

    public void setRound_off_for_opening(String round_off_for_opening) {
        this.round_off_for_opening = round_off_for_opening;
    }

    public String getDefault_deferred_revenue_account() {
        return default_deferred_revenue_account;
    }

    public void setDefault_deferred_revenue_account(String default_deferred_revenue_account) {
        this.default_deferred_revenue_account = default_deferred_revenue_account;
    }

    public String getDefault_deferred_expense_account() {
        return default_deferred_expense_account;
    }

    public void setDefault_deferred_expense_account(String default_deferred_expense_account) {
        this.default_deferred_expense_account = default_deferred_expense_account;
    }

    public int getBook_advance_payments_in_separate_party_account() {
        return book_advance_payments_in_separate_party_account;
    }

    public void setBook_advance_payments_in_separate_party_account(int book_advance_payments_in_separate_party_account) {
        this.book_advance_payments_in_separate_party_account = book_advance_payments_in_separate_party_account;
    }

    public int getReconcile_on_advance_payment_date() {
        return reconcile_on_advance_payment_date;
    }

    public void setReconcile_on_advance_payment_date(int reconcile_on_advance_payment_date) {
        this.reconcile_on_advance_payment_date = reconcile_on_advance_payment_date;
    }

    public String getReconciliation_takes_effect_on() {
        return reconciliation_takes_effect_on;
    }

    public void setReconciliation_takes_effect_on(String reconciliation_takes_effect_on) {
        this.reconciliation_takes_effect_on = reconciliation_takes_effect_on;
    }

    public String getDefault_advance_received_account() {
        return default_advance_received_account;
    }

    public void setDefault_advance_received_account(String default_advance_received_account) {
        this.default_advance_received_account = default_advance_received_account;
    }

    public String getDefault_advance_paid_account() {
        return default_advance_paid_account;
    }

    public void setDefault_advance_paid_account(String default_advance_paid_account) {
        this.default_advance_paid_account = default_advance_paid_account;
    }

    public int getAuto_exchange_rate_revaluation() {
        return auto_exchange_rate_revaluation;
    }

    public void setAuto_exchange_rate_revaluation(int auto_exchange_rate_revaluation) {
        this.auto_exchange_rate_revaluation = auto_exchange_rate_revaluation;
    }

    public String getAuto_err_frequency() {
        return auto_err_frequency;
    }

    public void setAuto_err_frequency(String auto_err_frequency) {
        this.auto_err_frequency = auto_err_frequency;
    }

    public int getSubmit_err_jv() {
        return submit_err_jv;
    }

    public void setSubmit_err_jv(int submit_err_jv) {
        this.submit_err_jv = submit_err_jv;
    }

    public String getException_budget_approver_role() {
        return exception_budget_approver_role;
    }

    public void setException_budget_approver_role(String exception_budget_approver_role) {
        this.exception_budget_approver_role = exception_budget_approver_role;
    }

    public String getAccumulated_depreciation_account() {
        return accumulated_depreciation_account;
    }

    public void setAccumulated_depreciation_account(String accumulated_depreciation_account) {
        this.accumulated_depreciation_account = accumulated_depreciation_account;
    }

    public String getDepreciation_expense_account() {
        return depreciation_expense_account;
    }

    public void setDepreciation_expense_account(String depreciation_expense_account) {
        this.depreciation_expense_account = depreciation_expense_account;
    }

    public String getSeries_for_depreciation_entry() {
        return series_for_depreciation_entry;
    }

    public void setSeries_for_depreciation_entry(String series_for_depreciation_entry) {
        this.series_for_depreciation_entry = series_for_depreciation_entry;
    }

    public String getDisposal_account() {
        return disposal_account;
    }

    public void setDisposal_account(String disposal_account) {
        this.disposal_account = disposal_account;
    }

    public String getDepreciation_cost_center() {
        return depreciation_cost_center;
    }

    public void setDepreciation_cost_center(String depreciation_cost_center) {
        this.depreciation_cost_center = depreciation_cost_center;
    }

    public String getCapital_work_in_progress_account() {
        return capital_work_in_progress_account;
    }

    public void setCapital_work_in_progress_account(String capital_work_in_progress_account) {
        this.capital_work_in_progress_account = capital_work_in_progress_account;
    }

    public String getAsset_received_but_not_billed() {
        return asset_received_but_not_billed;
    }

    public void setAsset_received_but_not_billed(String asset_received_but_not_billed) {
        this.asset_received_but_not_billed = asset_received_but_not_billed;
    }

    public String getDefault_buying_terms() {
        return default_buying_terms;
    }

    public void setDefault_buying_terms(String default_buying_terms) {
        this.default_buying_terms = default_buying_terms;
    }

    public String getSales_monthly_history() {
        return sales_monthly_history;
    }

    public void setSales_monthly_history(String sales_monthly_history) {
        this.sales_monthly_history = sales_monthly_history;
    }

    public double getMonthly_sales_target() {
        return monthly_sales_target;
    }

    public void setMonthly_sales_target(double monthly_sales_target) {
        this.monthly_sales_target = monthly_sales_target;
    }

    public double getTotal_monthly_sales() {
        return total_monthly_sales;
    }

    public void setTotal_monthly_sales(double total_monthly_sales) {
        this.total_monthly_sales = total_monthly_sales;
    }

    public String getDefault_selling_terms() {
        return default_selling_terms;
    }

    public void setDefault_selling_terms(String default_selling_terms) {
        this.default_selling_terms = default_selling_terms;
    }

    public String getDefault_warehouse_for_sales_return() {
        return default_warehouse_for_sales_return;
    }

    public void setDefault_warehouse_for_sales_return(String default_warehouse_for_sales_return) {
        this.default_warehouse_for_sales_return = default_warehouse_for_sales_return;
    }

    public double getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(double credit_limit) {
        this.credit_limit = credit_limit;
    }

    public String getTransactions_annual_history() {
        return transactions_annual_history;
    }

    public void setTransactions_annual_history(String transactions_annual_history) {
        this.transactions_annual_history = transactions_annual_history;
    }

    public int getEnable_perpetual_inventory() {
        return enable_perpetual_inventory;
    }

    public void setEnable_perpetual_inventory(int enable_perpetual_inventory) {
        this.enable_perpetual_inventory = enable_perpetual_inventory;
    }

    public int getEnable_provisional_accounting_for_non_stock_items() {
        return enable_provisional_accounting_for_non_stock_items;
    }

    public void setEnable_provisional_accounting_for_non_stock_items(
            int enable_provisional_accounting_for_non_stock_items) {
        this.enable_provisional_accounting_for_non_stock_items = enable_provisional_accounting_for_non_stock_items;
    }

    public String getDefault_inventory_account() {
        return default_inventory_account;
    }

    public void setDefault_inventory_account(String default_inventory_account) {
        this.default_inventory_account = default_inventory_account;
    }

    public String getStock_adjustment_account() {
        return stock_adjustment_account;
    }

    public void setStock_adjustment_account(String stock_adjustment_account) {
        this.stock_adjustment_account = stock_adjustment_account;
    }

    public String getStock_received_but_not_billed() {
        return stock_received_but_not_billed;
    }

    public void setStock_received_but_not_billed(String stock_received_but_not_billed) {
        this.stock_received_but_not_billed = stock_received_but_not_billed;
    }

    public String getDefault_provisional_account() {
        return default_provisional_account;
    }

    public void setDefault_provisional_account(String default_provisional_account) {
        this.default_provisional_account = default_provisional_account;
    }

    public String getDefault_in_transit_warehouse() {
        return default_in_transit_warehouse;
    }

    public void setDefault_in_transit_warehouse(String default_in_transit_warehouse) {
        this.default_in_transit_warehouse = default_in_transit_warehouse;
    }

    public String getDefault_operating_cost_account() {
        return default_operating_cost_account;
    }

    public void setDefault_operating_cost_account(String default_operating_cost_account) {
        this.default_operating_cost_account = default_operating_cost_account;
    }

    public String get_user_tags() {
        return _user_tags;
    }

    public void set_user_tags(String _user_tags) {
        this._user_tags = _user_tags;
    }

    public String get_comments() {
        return _comments;
    }

    public void set_comments(String _comments) {
        this._comments = _comments;
    }

    public String get_assign() {
        return _assign;
    }

    public void set_assign(String _assign) {
        this._assign = _assign;
    }

    public String get_liked_by() {
        return _liked_by;
    }

    public void set_liked_by(String _liked_by) {
        this._liked_by = _liked_by;
    }

    public String getDefault_expense_claim_payable_account() {
        return default_expense_claim_payable_account;
    }

    public void setDefault_expense_claim_payable_account(String default_expense_claim_payable_account) {
        this.default_expense_claim_payable_account = default_expense_claim_payable_account;
    }

    public String getDefault_employee_advance_account() {
        return default_employee_advance_account;
    }

    public void setDefault_employee_advance_account(String default_employee_advance_account) {
        this.default_employee_advance_account = default_employee_advance_account;
    }

    public String getDefault_payroll_payable_account() {
        return default_payroll_payable_account;
    }

    public void setDefault_payroll_payable_account(String default_payroll_payable_account) {
        this.default_payroll_payable_account = default_payroll_payable_account;
    }
    
}
