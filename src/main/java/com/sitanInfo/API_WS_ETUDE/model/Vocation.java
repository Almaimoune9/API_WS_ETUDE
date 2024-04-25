package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Vocation extends AbstractEntity{

    private String code;
    private String libelle;
    private String description;
    private Boolean etat;
}
