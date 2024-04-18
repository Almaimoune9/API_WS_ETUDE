package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Formation;

import java.util.List;
import java.util.Optional;

public interface FormationService {

    //Creer une formation
    String creer(Formation formation);

    //Afficher la liste des formation
    List<Formation> lire();

    //Afficher une formation
    Optional<Formation> findById(Integer id);

    //Supprimer une formation
    String modifier(Integer id, Formation formation);

    //Modifier une formation
    String supprimer(Integer id);
}
