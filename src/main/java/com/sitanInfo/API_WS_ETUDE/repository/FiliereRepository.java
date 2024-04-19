package com.sitanInfo.API_WS_ETUDE.repository;

import com.sitanInfo.API_WS_ETUDE.model.Filieres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filieres, Integer> {

    Filieres getByCode(String code);
}
