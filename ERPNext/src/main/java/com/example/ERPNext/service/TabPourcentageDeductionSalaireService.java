package com.example.ERPNext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERPNext.entity.frappeHR.TabPourcentageDeductionSalaire;
import com.example.ERPNext.repository.TabPourcentageDeductionSalaireRepository;

@Service
public class TabPourcentageDeductionSalaireService {
    
    @Autowired
    private TabPourcentageDeductionSalaireRepository tabPourcentageDeductionSalaireRepository;

    public List<TabPourcentageDeductionSalaire> getAll() {
        return tabPourcentageDeductionSalaireRepository.findAll();
    }

}
