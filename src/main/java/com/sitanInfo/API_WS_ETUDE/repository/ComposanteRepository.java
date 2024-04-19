package com.sitanInfo.API_WS_ETUDE.repository;

import com.sitanInfo.API_WS_ETUDE.model.Composante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposanteRepository extends JpaRepository<Composante, Integer> {

    Composante getByNom(String nom);
}
