package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Module;
import com.sitanInfo.API_WS_ETUDE.model.TypeAtome;

import java.util.List;
import java.util.Optional;

public interface TypeAtomeService {

    //Methode pour creer un TypeAtome
    String creer(TypeAtome typeAtome);

    //Afficher la liste des TypeAtome
    List<TypeAtome> lire();

    //Afficher un TypeAtome
    Optional<TypeAtome> findById(Integer id);

    //Modifier un TypeAtome
    String modifier(Integer id, TypeAtome typeAtome);

    //Supprimer un TypeAtome
    String supprimer(Integer id);
}
