package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Atomes extends AbstractEntity{

    private Integer seuil;
    private Integer goupePrevu;
    private Integer groupeReel;
    private Integer valeur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matieres")
    private Matieres matieres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeAtome")
    private TypeAtome typeAtome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modesAtomes")
    private ModesAtomes modesAtomes;
}
