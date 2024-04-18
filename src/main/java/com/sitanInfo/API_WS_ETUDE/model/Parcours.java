package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Parcours extends AbstractEntity{



    private String code;
    private String libelle;
    private Double credit;
    private Double tauxProgression;
    private boolean semestreObligatoire;
    private Boolean etat;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vocation")
    private EVocation vocation;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formations")
    private Formation formations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablissement")
    private Etablissement etablissement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formationsSpecialisation")
    private FormationsSpecialisation formationsSpecialisation;

}
