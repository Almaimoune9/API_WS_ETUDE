package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Parcours;

import java.util.List;
import java.util.Optional;

public interface ParcoursService {

    //Créer un parcours
    String creer(Parcours parcours);

    //Afficher la liste des parcours
    List<Parcours> lire();

    //Afficher un parcours
    Optional<Parcours> findById(Integer id);

    //Modifier un parcours
    String modifier(Integer id, Parcours parcours);

    //Supprimer un parcours
    String supprimer(Integer id);
}
