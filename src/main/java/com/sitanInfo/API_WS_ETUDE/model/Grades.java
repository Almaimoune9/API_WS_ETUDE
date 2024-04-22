package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Grades extends AbstractEntity{

    private  String code;
    private String libelle;
    private  String type;
    private String nbreAnnee;
    private Boolean etat;

}
