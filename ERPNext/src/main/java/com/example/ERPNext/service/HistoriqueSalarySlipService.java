package com.example.ERPNext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERPNext.entity.frappeHR.HistoriqueSalarySlip;
import com.example.ERPNext.repository.HistoriqueSalarySlipRepository;



@Service
public class HistoriqueSalarySlipService {
    
    @Autowired
    private HistoriqueSalarySlipRepository historiqueSalarySlipRepository;

    public List<HistoriqueSalarySlip> getAll() {
        return historiqueSalarySlipRepository.findAll();
    }

    public HistoriqueSalarySlip save(HistoriqueSalarySlip historiqueSalarySlip) {
        return historiqueSalarySlipRepository.save(historiqueSalarySlip);
    }

}
