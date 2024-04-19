package com.sitanInfo.API_WS_ETUDE.repository;

import com.sitanInfo.API_WS_ETUDE.model.Atomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtomeRepository extends JpaRepository<Atomes, Integer> {
}
