package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Habilitation extends AbstractEntity{

    private Date debutHabilitation;
    private Date finHabilitation;
}
