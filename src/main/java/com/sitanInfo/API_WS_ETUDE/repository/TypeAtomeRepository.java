package com.sitanInfo.API_WS_ETUDE.repository;

import com.sitanInfo.API_WS_ETUDE.model.TypeAtome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAtomeRepository extends JpaRepository<TypeAtome, Integer> {

    TypeAtome getByCode(String code);
}
