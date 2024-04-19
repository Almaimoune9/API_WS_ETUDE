package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class TypeAtome extends AbstractEntity{

    private String code;
    private String libelle;
    private Integer priorite;
    private Integer numerateur;
    private Integer denominateur;
    private Integer seuil;
    private Boolean etat;
    private boolean selected;
}
