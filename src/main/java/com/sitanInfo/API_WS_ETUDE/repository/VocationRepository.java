package com.sitanInfo.API_WS_ETUDE.repository;
import com.sitanInfo.API_WS_ETUDE.model.Vocation;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface VocationRepository extends JpaRepository<Vocation, Integer> {
    Vocation getByCode(String code);
}
