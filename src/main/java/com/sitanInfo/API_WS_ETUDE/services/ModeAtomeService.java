package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.ModesAtomes;
import com.sitanInfo.API_WS_ETUDE.model.Module;

import java.util.List;
import java.util.Optional;

public interface ModeAtomeService {

    //Methode pour creer un modesAtomes
    String creer(ModesAtomes modesAtomes);

    //Afficher la liste des modesAtomes
    List<ModesAtomes> lire();

    //Afficher un modesAtomes
    Optional<ModesAtomes> findById(Integer id);

    //Modifier un modesAtomes
    String modifier(Integer id, ModesAtomes modesAtomes);

    //Supprimer un modesAtomes
    String supprimer(Integer id);
}
