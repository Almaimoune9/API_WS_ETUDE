package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Composante extends AbstractEntity{

    private String code;
    private String nom;
    private String description;
    private boolean selected;
}
