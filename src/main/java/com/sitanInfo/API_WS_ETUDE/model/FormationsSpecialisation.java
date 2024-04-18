package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FormationsSpecialisation extends AbstractEntity{



    private String libelle;
    private String abreviation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formations")
    private Formation formations;
}
