package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Mention extends AbstractEntity{

    private String code;
    private String nom;
    private boolean etat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domaine")
    private Domaine domaine;
}
