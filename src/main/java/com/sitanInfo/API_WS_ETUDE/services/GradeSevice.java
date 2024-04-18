package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Grades;

import java.util.List;
import java.util.Optional;

public interface GradeSevice {

    //Créer une grade
    String creer(Grades grades);

    //Afficher la liste
    List<Grades> lire();

    //Afficher une grade
    Optional<Grades> findByid(Integer id);

    //Supprimer une grades
    String supprimer(Integer id);

    //Modifier une grades
    String modifier(Integer id, Grades grades);
}
