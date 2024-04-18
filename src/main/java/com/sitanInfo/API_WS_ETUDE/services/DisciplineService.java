package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {

    //Methode pour creer une discipline
    String creer(Discipline discipline);

    //Methode pour la liste des disciplines
    List<Discipline> lire();

    //Methode pour lire une discipline
    Optional<Discipline> findById(Integer id);

    //Methode pour modifier une displine
    Discipline modifier(Integer id, Discipline discipline);

    //Methode pour supprimer une discipline
    String supprimer(Integer id);
}
