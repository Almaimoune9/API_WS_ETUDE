package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Matieres;

import java.util.List;
import java.util.Optional;

public interface MatiereService {
    //Methode pour creer une matiere
    String creer(Matieres matieres);

    //Afficher la liste des matieres
    List<Matieres> lire();

    //Afficher une matires
    Optional<Matieres> finbyId(Integer id);

    //Modifier une matiere
    Matieres modifier(Integer id, Matieres matieres);

    //Supprimer une matiere
    String supprimer(Integer id);
}
