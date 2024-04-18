package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Etablissement extends AbstractEntity{

    private String code;
    private String nom;
    private String abreviation;
    private String identifiantEtab;
    private String groupe;
    private String pays;
    private String ville;
    private String adresse;
    private String type;
    private String tel;
}
