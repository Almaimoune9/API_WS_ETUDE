package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Filieres;
import com.sitanInfo.API_WS_ETUDE.model.Module;

import java.util.List;
import java.util.Optional;

public interface FiliereService {

    //Methode pour creer une filiere
    String creer(Filieres filieres);

    //Afficher la liste des filiere
    List<Filieres> lire();

    //Afficher une filiere
    Optional<Filieres> findById(Integer id);

    //Modifier une filiere
    String modifier(Integer id, Filieres filieres);

    //Supprimer une filiere
    String supprimer(Integer id);
}
