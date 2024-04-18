package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.AnneeAcademique;

import java.util.List;
import java.util.Optional;

public interface AnneeAcademiqueService {

    //Creer une annee academique
    AnneeAcademique creerAnneeAcademique(AnneeAcademique anneeAcademique);

    //Afficher la liste
    List<AnneeAcademique> lire();

    //Afficher une anneeAcademique
    Optional<AnneeAcademique> findById(Integer id);

    //Supprimer AnneeAcamique
    String supprimer(Integer id);
}
