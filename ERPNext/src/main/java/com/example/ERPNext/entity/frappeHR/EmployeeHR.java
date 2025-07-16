package com.example.ERPNext.entity.frappeHR;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeHR {
    
    public String name;
	public String creation;
	public String modified;
	public String modified_by;
	public String owner;
	public int docstatus;
	public int idx;
	public String employee;
	public String naming_series;
	public String first_name;
	public String middle_name;
	public String last_name;
	public String employee_name;
	public String gender;
	public String date_of_birth;
	public String salutation;
	public String date_of_joining;
	public String image;
	public String status;
	public String user_id;
	public int create_user_permission;
	public String company;
	public String department;
	public String employee_number;
	public String designation;
	public String reports_to;
	public String branch;
	public String scheduled_confirmation_date;
	public String final_confirmation_date;
	public String contract_end_date;
	public int notice_number_of_days;
	public String date_of_retirement;
	public String cell_number;
	public String personal_email;
	public String company_email;
	public String prefered_contact_email;
	public String prefered_email;
	public int unsubscribed;
	public String current_address;
	public String current_accommodation_type;
	public String permanent_address;
	public String permanent_accommodation_type;
	public String person_to_be_contacted;
	public String emergency_phone_number;
	public String relation;
	public String attendance_device_id;
	public String holiday_list;
	public double ctc;
	public String salary_currency;
	public String salary_mode;
	public String bank_name;
	public String bank_ac_no;
	public String iban;
	public String marital_status;
	public String family_background;
	public String blood_group;
	public String health_details;
	public String passport_number;
	public String valid_upto;
	public String date_of_issue;
	public String place_of_issue;
	public String bio;
	public String resignation_letter_date;
	public String relieving_date;
	public String held_on;
	public String new_workplace;
	public String leave_encashed;
	public String encashment_date;
	public String reason_for_leaving;
	public String feedback;
	public int lft;
	public int rgt;
	public String old_parent;
	public String user_tags;
	public String comments;
	public String assign;
	public String liked_by;
	public String employment_type;
	public String grade;
	public String job_applicant;
	public String default_shift;
	public String expense_approver;
	public String leave_approver;
	public String shift_request_approver;
	public String payroll_cost_center;
	public String health_insurance_provider;
	public String health_insurance_no;

    public EmployeeHR() {
    }

    public EmployeeHR(String name, String creation, String modified, String modified_by, String owner, int docstatus,
            int idx, String employee, String naming_series, String first_name, String middle_name, String last_name,
            String employee_name, String gender, String date_of_birth, String salutation, String date_of_joining,
            String image, String status, String user_id, int create_user_permission, String company, String department,
            String employee_number, String designation, String reports_to, String branch,
            String scheduled_confirmation_date, String final_confirmation_date, String contract_end_date,
            int notice_number_of_days, String date_of_retirement, String cell_number, String personal_email,
            String company_email, String prefered_contact_email, String prefered_email, int unsubscribed,
            String current_address, String current_accommodation_type, String permanent_address,
            String permanent_accommodation_type, String person_to_be_contacted, String emergency_phone_number,
            String relation, String attendance_device_id, String holiday_list, double ctc, String salary_currency,
            String salary_mode, String bank_name, String bank_ac_no, String iban, String marital_status,
            String family_background, String blood_group, String health_details, String passport_number,
            String valid_upto, String date_of_issue, String place_of_issue, String bio, String resignation_letter_date,
            String relieving_date, String held_on, String new_workplace, String leave_encashed, String encashment_date,
            String reason_for_leaving, String feedback, int lft, int rgt, String old_parent, String user_tags,
            String comments, String assign, String liked_by, String employment_type, String grade, String job_applicant,
            String default_shift, String expense_approver, String leave_approver, String shift_request_approver,
            String payroll_cost_center, String health_insurance_provider, String health_insurance_no) {
        this.name = name;
        this.creation = creation;
        this.modified = modified;
        this.modified_by = modified_by;
        this.owner = owner;
        this.docstatus = docstatus;
        this.idx = idx;
        this.employee = employee;
        this.naming_series = naming_series;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.employee_name = employee_name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.salutation = salutation;
        this.date_of_joining = date_of_joining;
        this.image = image;
        this.status = status;
        this.user_id = user_id;
        this.create_user_permission = create_user_permission;
        this.company = company;
        this.department = department;
        this.employee_number = employee_number;
        this.designation = designation;
        this.reports_to = reports_to;
        this.branch = branch;
        this.scheduled_confirmation_date = scheduled_confirmation_date;
        this.final_confirmation_date = final_confirmation_date;
        this.contract_end_date = contract_end_date;
        this.notice_number_of_days = notice_number_of_days;
        this.date_of_retirement = date_of_retirement;
        this.cell_number = cell_number;
        this.personal_email = personal_email;
        this.company_email = company_email;
        this.prefered_contact_email = prefered_contact_email;
        this.prefered_email = prefered_email;
        this.unsubscribed = unsubscribed;
        this.current_address = current_address;
        this.current_accommodation_type = current_accommodation_type;
        this.permanent_address = permanent_address;
        this.permanent_accommodation_type = permanent_accommodation_type;
        this.person_to_be_contacted = person_to_be_contacted;
        this.emergency_phone_number = emergency_phone_number;
        this.relation = relation;
        this.attendance_device_id = attendance_device_id;
        this.holiday_list = holiday_list;
        this.ctc = ctc;
        this.salary_currency = salary_currency;
        this.salary_mode = salary_mode;
        this.bank_name = bank_name;
        this.bank_ac_no = bank_ac_no;
        this.iban = iban;
        this.marital_status = marital_status;
        this.family_background = family_background;
        this.blood_group = blood_group;
        this.health_details = health_details;
        this.passport_number = passport_number;
        this.valid_upto = valid_upto;
        this.date_of_issue = date_of_issue;
        this.place_of_issue = place_of_issue;
        this.bio = bio;
        this.resignation_letter_date = resignation_letter_date;
        this.relieving_date = relieving_date;
        this.held_on = held_on;
        this.new_workplace = new_workplace;
        this.leave_encashed = leave_encashed;
        this.encashment_date = encashment_date;
        this.reason_for_leaving = reason_for_leaving;
        this.feedback = feedback;
        this.lft = lft;
        this.rgt = rgt;
        this.old_parent = old_parent;
        this.user_tags = user_tags;
        this.comments = comments;
        this.assign = assign;
        this.liked_by = liked_by;
        this.employment_type = employment_type;
        this.grade = grade;
        this.job_applicant = job_applicant;
        this.default_shift = default_shift;
        this.expense_approver = expense_approver;
        this.leave_approver = leave_approver;
        this.shift_request_approver = shift_request_approver;
        this.payroll_cost_center = payroll_cost_center;
        this.health_insurance_provider = health_insurance_provider;
        this.health_insurance_no = health_insurance_no;
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
    public String getNaming_series() {
        return naming_series;
    }
    public void setNaming_series(String naming_series) {
        this.naming_series = naming_series;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getMiddle_name() {
        return middle_name;
    }
    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDate_of_birth() {
        return date_of_birth;
    }
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    public String getSalutation() {
        return salutation;
    }
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }
    public String getDate_of_joining() {
        return date_of_joining;
    }
    public void setDate_of_joining(String date_of_joining) {
        this.date_of_joining = date_of_joining;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public int getCreate_user_permission() {
        return create_user_permission;
    }
    public void setCreate_user_permission(int create_user_permission) {
        this.create_user_permission = create_user_permission;
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
    public String getEmployee_number() {
        return employee_number;
    }
    public void setEmployee_number(String employee_number) {
        this.employee_number = employee_number;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getReports_to() {
        return reports_to;
    }
    public void setReports_to(String reports_to) {
        this.reports_to = reports_to;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getScheduled_confirmation_date() {
        return scheduled_confirmation_date;
    }
    public void setScheduled_confirmation_date(String scheduled_confirmation_date) {
        this.scheduled_confirmation_date = scheduled_confirmation_date;
    }
    public String getFinal_confirmation_date() {
        return final_confirmation_date;
    }
    public void setFinal_confirmation_date(String final_confirmation_date) {
        this.final_confirmation_date = final_confirmation_date;
    }
    public String getContract_end_date() {
        return contract_end_date;
    }
    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }
    public int getNotice_number_of_days() {
        return notice_number_of_days;
    }
    public void setNotice_number_of_days(int notice_number_of_days) {
        this.notice_number_of_days = notice_number_of_days;
    }
    public String getDate_of_retirement() {
        return date_of_retirement;
    }
    public void setDate_of_retirement(String date_of_retirement) {
        this.date_of_retirement = date_of_retirement;
    }
    public String getCell_number() {
        return cell_number;
    }
    public void setCell_number(String cell_number) {
        this.cell_number = cell_number;
    }
    public String getPersonal_email() {
        return personal_email;
    }
    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }
    public String getCompany_email() {
        return company_email;
    }
    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }
    public String getPrefered_contact_email() {
        return prefered_contact_email;
    }
    public void setPrefered_contact_email(String prefered_contact_email) {
        this.prefered_contact_email = prefered_contact_email;
    }
    public String getPrefered_email() {
        return prefered_email;
    }
    public void setPrefered_email(String prefered_email) {
        this.prefered_email = prefered_email;
    }
    public int getUnsubscribed() {
        return unsubscribed;
    }
    public void setUnsubscribed(int unsubscribed) {
        this.unsubscribed = unsubscribed;
    }
    public String getCurrent_address() {
        return current_address;
    }
    public void setCurrent_address(String current_address) {
        this.current_address = current_address;
    }
    public String getCurrent_accommodation_type() {
        return current_accommodation_type;
    }
    public void setCurrent_accommodation_type(String current_accommodation_type) {
        this.current_accommodation_type = current_accommodation_type;
    }
    public String getPermanent_address() {
        return permanent_address;
    }
    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }
    public String getPermanent_accommodation_type() {
        return permanent_accommodation_type;
    }
    public void setPermanent_accommodation_type(String permanent_accommodation_type) {
        this.permanent_accommodation_type = permanent_accommodation_type;
    }
    public String getPerson_to_be_contacted() {
        return person_to_be_contacted;
    }
    public void setPerson_to_be_contacted(String person_to_be_contacted) {
        this.person_to_be_contacted = person_to_be_contacted;
    }
    public String getEmergency_phone_number() {
        return emergency_phone_number;
    }
    public void setEmergency_phone_number(String emergency_phone_number) {
        this.emergency_phone_number = emergency_phone_number;
    }
    public String getRelation() {
        return relation;
    }
    public void setRelation(String relation) {
        this.relation = relation;
    }
    public String getAttendance_device_id() {
        return attendance_device_id;
    }
    public void setAttendance_device_id(String attendance_device_id) {
        this.attendance_device_id = attendance_device_id;
    }
    public String getHoliday_list() {
        return holiday_list;
    }
    public void setHoliday_list(String holiday_list) {
        this.holiday_list = holiday_list;
    }
    public double getCtc() {
        return ctc;
    }
    public void setCtc(double ctc) {
        this.ctc = ctc;
    }
    public String getSalary_currency() {
        return salary_currency;
    }
    public void setSalary_currency(String salary_currency) {
        this.salary_currency = salary_currency;
    }
    public String getSalary_mode() {
        return salary_mode;
    }
    public void setSalary_mode(String salary_mode) {
        this.salary_mode = salary_mode;
    }
    public String getBank_name() {
        return bank_name;
    }
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }
    public String getBank_ac_no() {
        return bank_ac_no;
    }
    public void setBank_ac_no(String bank_ac_no) {
        this.bank_ac_no = bank_ac_no;
    }
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public String getMarital_status() {
        return marital_status;
    }
    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }
    public String getFamily_background() {
        return family_background;
    }
    public void setFamily_background(String family_background) {
        this.family_background = family_background;
    }
    public String getBlood_group() {
        return blood_group;
    }
    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }
    public String getHealth_details() {
        return health_details;
    }
    public void setHealth_details(String health_details) {
        this.health_details = health_details;
    }
    public String getPassport_number() {
        return passport_number;
    }
    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }
    public String getValid_upto() {
        return valid_upto;
    }
    public void setValid_upto(String valid_upto) {
        this.valid_upto = valid_upto;
    }
    public String getDate_of_issue() {
        return date_of_issue;
    }
    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }
    public String getPlace_of_issue() {
        return place_of_issue;
    }
    public void setPlace_of_issue(String place_of_issue) {
        this.place_of_issue = place_of_issue;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getResignation_letter_date() {
        return resignation_letter_date;
    }
    public void setResignation_letter_date(String resignation_letter_date) {
        this.resignation_letter_date = resignation_letter_date;
    }
    public String getRelieving_date() {
        return relieving_date;
    }
    public void setRelieving_date(String relieving_date) {
        this.relieving_date = relieving_date;
    }
    public String getHeld_on() {
        return held_on;
    }
    public void setHeld_on(String held_on) {
        this.held_on = held_on;
    }
    public String getNew_workplace() {
        return new_workplace;
    }
    public void setNew_workplace(String new_workplace) {
        this.new_workplace = new_workplace;
    }
    public String getLeave_encashed() {
        return leave_encashed;
    }
    public void setLeave_encashed(String leave_encashed) {
        this.leave_encashed = leave_encashed;
    }
    public String getEncashment_date() {
        return encashment_date;
    }
    public void setEncashment_date(String encashment_date) {
        this.encashment_date = encashment_date;
    }
    public String getReason_for_leaving() {
        return reason_for_leaving;
    }
    public void setReason_for_leaving(String reason_for_leaving) {
        this.reason_for_leaving = reason_for_leaving;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
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
    public String getEmployment_type() {
        return employment_type;
    }
    public void setEmployment_type(String employment_type) {
        this.employment_type = employment_type;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getJob_applicant() {
        return job_applicant;
    }
    public void setJob_applicant(String job_applicant) {
        this.job_applicant = job_applicant;
    }
    public String getDefault_shift() {
        return default_shift;
    }
    public void setDefault_shift(String default_shift) {
        this.default_shift = default_shift;
    }
    public String getExpense_approver() {
        return expense_approver;
    }
    public void setExpense_approver(String expense_approver) {
        this.expense_approver = expense_approver;
    }
    public String getLeave_approver() {
        return leave_approver;
    }
    public void setLeave_approver(String leave_approver) {
        this.leave_approver = leave_approver;
    }
    public String getShift_request_approver() {
        return shift_request_approver;
    }
    public void setShift_request_approver(String shift_request_approver) {
        this.shift_request_approver = shift_request_approver;
    }
    public String getPayroll_cost_center() {
        return payroll_cost_center;
    }
    public void setPayroll_cost_center(String payroll_cost_center) {
        this.payroll_cost_center = payroll_cost_center;
    }
    public String getHealth_insurance_provider() {
        return health_insurance_provider;
    }
    public void setHealth_insurance_provider(String health_insurance_provider) {
        this.health_insurance_provider = health_insurance_provider;
    }
    public String getHealth_insurance_no() {
        return health_insurance_no;
    }
    public void setHealth_insurance_no(String health_insurance_no) {
        this.health_insurance_no = health_insurance_no;
    }
    
    

}

// public class EmployeeHR {
    
//     private String employee_name ;
//     private String gender  ;
//     private String date_of_birth  ;
//     private String date_of_joining  ;
//     private String status  ;

//     public EmployeeHR(String employee_name, String gender, String date_of_birth, String date_of_joining,
//             String status) {
//         this.employee_name = employee_name;
//         this.gender = gender;
//         this.date_of_birth = date_of_birth;
//         this.date_of_joining = date_of_joining;
//         this.status = status;
//     }
    
//     public String getEmployee_name() {
//         return employee_name;
//     }
//     public void setEmployee_name(String employee_name) {
//         this.employee_name = employee_name;
//     }
//     public String getGender() {
//         return gender;
//     }
//     public void setGender(String gender) {
//         this.gender = gender;
//     }
//     public String getDate_of_birth() {
//         return date_of_birth;
//     }
//     public void setDate_of_birth(String date_of_birth) {
//         this.date_of_birth = date_of_birth;
//     }
//     public String getDate_of_joining() {
//         return date_of_joining;
//     }
//     public void setDate_of_joining(String date_of_joining) {
//         this.date_of_joining = date_of_joining;
//     }
//     public String getStatus() {
//         return status;
//     }
//     public void setStatus(String status) {
//         this.status = status;
//     }

    
// }