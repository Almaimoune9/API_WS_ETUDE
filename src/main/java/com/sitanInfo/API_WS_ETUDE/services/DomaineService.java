package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Domaine;

import java.util.List;
import java.util.Optional;

public interface DomaineService {

    //Méthode pour créer un domaine
    String creer(Domaine domaine);

    //Methode pour afficher la liste des domaines
    List<Domaine> lire();

    //Modifier un domaine
    Domaine modifier(Integer id, Domaine domaine);

    //Supprimer un domaine
    String supprimer(Integer id);

    //Afficher un domaine
    Optional<Domaine> findByid(Integer id);
}
