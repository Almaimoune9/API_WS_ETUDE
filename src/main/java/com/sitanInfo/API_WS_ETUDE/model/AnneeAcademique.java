package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class AnneeAcademique extends AbstractEntity{


    private String anneeAcademique;
    /*private Long anneeDeb;
    private Long anneeFin;*/
    private Date dateDeb;
    private Date dateFin;
    private String objectif;
    /*private Boolean isActif;*/
    private Date dateCloture;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "etablissement")
    private Etablissement etablissement;
}
