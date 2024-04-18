package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Vocation extends AbstractEntity{

    private String code;
    private String libelle;
    private String description;
    private Boolean etat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablissement")
    private Etablissement etablissement;

}
