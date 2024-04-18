package com.sitanInfo.API_WS_ETUDE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Domaine extends AbstractEntity{

    private String code;
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etablissement")
    private Etablissement etablissement;
}
