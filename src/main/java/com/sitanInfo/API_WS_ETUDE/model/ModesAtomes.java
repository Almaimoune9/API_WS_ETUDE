package com.sitanInfo.API_WS_ETUDE.model;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ModesAtomes extends AbstractEntity{

    private String code;
    private String libelle;
    private Integer priorite;
    private Boolean payable;
    private Boolean etat;
}
