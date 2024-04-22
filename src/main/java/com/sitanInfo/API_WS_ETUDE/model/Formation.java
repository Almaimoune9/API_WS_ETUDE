package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Formation extends AbstractEntity{


    private String code;
    private String libelle;
    private String specialite;
    private String specialisation;
    private String type;
    private Boolean etat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grades")
    private Grades grades;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domaine")
    private Domaine domaine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departement")
    private Departement departement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vocation")
    private Vocation vocation;
}
