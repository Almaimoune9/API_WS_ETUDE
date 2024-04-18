package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Module;

import java.util.List;
import java.util.Optional;

public interface ModuleService {
    //Methode pour creer un module
    String creer(Module module);

    //Afficher la liste des modules
    List<Module> lire();

    //Afficher un module
    Optional<Module> findById(Integer id);

    //Modifier un module
    String modifier(Integer id, Module module);

    //Supprimer un module
    String supprimer(Integer id);
}
