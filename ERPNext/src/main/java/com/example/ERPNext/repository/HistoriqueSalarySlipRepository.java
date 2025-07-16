package com.example.ERPNext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERPNext.entity.frappeHR.HistoriqueSalarySlip;

public interface HistoriqueSalarySlipRepository extends JpaRepository<HistoriqueSalarySlip , Integer>  {
    
}
