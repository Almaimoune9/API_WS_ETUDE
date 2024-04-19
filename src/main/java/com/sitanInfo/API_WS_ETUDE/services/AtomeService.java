package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Atomes;
import com.sitanInfo.API_WS_ETUDE.model.Module;

import java.util.List;
import java.util.Optional;

public interface AtomeService {

    //Methode pour creer un atome
    String creer(Atomes atomes);

    //Afficher la liste des atome
    List<Atomes> lire();

    //Afficher un atome
    Optional<Atomes> findById(Integer id);

    //Modifier un atome
    String modifier(Integer id, Atomes atomes);

    //Supprimer un atome
    String supprimer(Integer id);
}
