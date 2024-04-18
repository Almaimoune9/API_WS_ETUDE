package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Departement;
import com.sitanInfo.API_WS_ETUDE.model.Module;

import java.util.List;
import java.util.Optional;

public interface DepartementService {
    //Methode pour creer un departement
    String creer(Departement departement);

    //Afficher la liste des departement
    List<Departement> lire();

    //Afficher un departement
    Optional<Departement> findById(Integer id);

    //Modifier un departement
    String modifier(Integer id, Departement departement);

    //Supprimer un departement
    String supprimer(Integer id);
}
