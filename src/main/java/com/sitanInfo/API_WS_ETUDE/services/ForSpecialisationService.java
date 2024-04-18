package com.sitanInfo.API_WS_ETUDE.services;


import com.sitanInfo.API_WS_ETUDE.model.Domaine;
import com.sitanInfo.API_WS_ETUDE.model.FormationsSpecialisation;

import java.util.List;
import java.util.Optional;

public interface ForSpecialisationService {

    //Méthode pour créer une formation
    String creer(FormationsSpecialisation formationsSpecialisation);

    //Methode pour afficher la liste des formations
    List<FormationsSpecialisation> lire();

    //Modifier une formation
    String modifier(Integer id, FormationsSpecialisation formationsSpecialisation);

    //Supprimer une formation
    String supprimer(Integer id);

    //Afficher une formation
    Optional<FormationsSpecialisation> findByid(Integer id);
}
