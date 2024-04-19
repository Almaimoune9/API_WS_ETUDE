package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Composante;
import com.sitanInfo.API_WS_ETUDE.model.Module;

import java.util.List;
import java.util.Optional;

public interface ComposanteService {

    //Methode pour creer une composante
    String creer(Composante composante);

    //Afficher la liste des composante
    List<Composante> lire();

    //Afficher une composante
    Optional<Composante> findById(Integer id);

    //Modifier une composante
    String modifier(Integer id, Composante composante);

    //Supprimer une composante
    String supprimer(Integer id);
}
