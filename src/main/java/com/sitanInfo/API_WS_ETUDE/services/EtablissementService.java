package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Etablissement;

import java.util.List;
import java.util.Optional;

public interface EtablissementService {

    //Methode pour créer un etablissement
    String creer(Etablissement etablissement);

    //Afficher la liste des etablissements
    List<Etablissement> lire();

    //Modifier un etablissement
    Etablissement modifier(Integer id, Etablissement etablissement);

    //Supprimer un etablissement
    String supprimer(Integer id);

    //Afficher un etablissement
    Optional<Etablissement> findById(Integer id);
}
