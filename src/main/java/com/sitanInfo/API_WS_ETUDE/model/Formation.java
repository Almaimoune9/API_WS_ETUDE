package com.sitanInfo.API_WS_ETUDE.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Formation extends AbstractEntity{


    private String code;
    private String libelle;
    /*private Date debutHabilitation;
    private Date finHabilitation;*/
    private String depart;
    private String arrivee;
    private Boolean etat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domaine")
    @JsonIgnore
    private Domaine domaine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mention")
    @JsonIgnore
    private Mention mention;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade")
    @JsonIgnore
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vocation")
    @JsonIgnore
    private Vocation vocation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "habilitation_id")
    private Habilitation habilitation;

}
