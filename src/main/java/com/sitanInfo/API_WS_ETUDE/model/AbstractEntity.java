package com.sitanInfo.API_WS_ETUDE.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable, Comparable <AbstractEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)

    @Override
    public int compareTo(AbstractEntity o) {
        return 0;
    }
}
