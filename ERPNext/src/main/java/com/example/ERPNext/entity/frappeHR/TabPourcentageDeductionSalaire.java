package com.example.ERPNext.entity.frappeHR;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_pourcentage_deduction_salaire")
public class TabPourcentageDeductionSalaire {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pds")
    private Integer idPds;

    @Column(name = "mois" , length = 255 ,nullable = false)
    private String mois;

    @Column(name = "valeur" ,  precision = 15, scale = 2)
    private BigDecimal valeur;


    public Integer getIdPds() {
        return idPds;
    }

    public void setIdPds(Integer idPds) {
        this.idPds = idPds;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }
    
}
