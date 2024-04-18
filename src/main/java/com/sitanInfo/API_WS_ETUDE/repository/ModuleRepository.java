package com.sitanInfo.API_WS_ETUDE.repository;


import com.sitanInfo.API_WS_ETUDE.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
    Module getByCode(String code);

}
