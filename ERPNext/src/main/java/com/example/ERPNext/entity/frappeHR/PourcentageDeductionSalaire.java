package com.example.ERPNext.entity.frappeHR;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "tabPourcentageDeductionSalaire")
public class PourcentageDeductionSalaire {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "valeur" , nullable = false, precision = 15, scale = 2)
    private BigDecimal valeur;

}
