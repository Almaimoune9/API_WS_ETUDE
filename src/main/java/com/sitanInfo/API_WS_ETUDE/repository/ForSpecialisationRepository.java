package com.sitanInfo.API_WS_ETUDE.repository;

import com.sitanInfo.API_WS_ETUDE.model.FormationsSpecialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForSpecialisationRepository extends JpaRepository<FormationsSpecialisation, Integer> {
    String getByAbreviation(String abreviation);
}
