package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Vocation;

import java.util.List;
import java.util.Optional;

public interface VocationService {

    //Methode pour creer une vocation
    String creer(Vocation vocation);

    //Afficher la liste des vocations
    List<Vocation> lire();

    //Afficher une vocation
    Optional<Vocation> findById(Integer id);

    //Modifier une vocation
    String modifier(Integer id, Vocation vocation);

    //Supprimer une vocation
    String supprimer(Integer id);
}
