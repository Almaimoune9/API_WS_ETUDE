package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Discipline extends AbstractEntity {

    private String code;
    private String nom;


}
