package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;


@Data
public class FormationCreationRequest {
    private Formation formation;
    private Date debutHabilitation;
    private Date finHabilitation;
}
