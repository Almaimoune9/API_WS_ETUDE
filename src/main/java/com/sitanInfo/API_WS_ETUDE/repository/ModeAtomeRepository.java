package com.sitanInfo.API_WS_ETUDE.repository;

import com.sitanInfo.API_WS_ETUDE.model.ModesAtomes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeAtomeRepository extends JpaRepository<ModesAtomes, Integer> {

    ModesAtomes getByCode(String code);
}
