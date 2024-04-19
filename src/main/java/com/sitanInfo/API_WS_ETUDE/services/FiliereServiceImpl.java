package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Filieres;

import com.sitanInfo.API_WS_ETUDE.repository.FiliereRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class FiliereServiceImpl implements FiliereService{

    @Autowired
    private FiliereRepository filiereRepository;

    @Override
    public String creer(Filieres filieres) {
        try {
            Filieres filiereExiste = filiereRepository.getByCode(filieres.getCode());
            if (filiereExiste != null) {
                return "Cette filiere existe deja";
            } else {
                filiereRepository.save(filieres);
                return "Filieres créer avec succés";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la création de la filiere.";
        }
    }

    @Override
    public List<Filieres> lire() {
        return filiereRepository.findAll();
    }

    @Override
    public Optional<Filieres> findById(Integer id) {
        return filiereRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, Filieres filieres) {
        try {
            //Recherche la filiere par son id
            Filieres filiereModifier = filiereRepository.findById(id).orElse(null);

            if (filiereModifier == null) {
                return "Filiere non trouvé";
            }
            //Mettre à jour les informations du module
            filiereModifier.setCode(filieres.getCode());
            filiereModifier.setEtat(filieres.getEtat());
            filiereModifier.setLibelle(filieres.getLibelle());


            //Enregistrer les modifications
            filiereRepository.save(filiereModifier);

            return "Filiere modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de la filiere.";
        }
    }


    @Override
    public String supprimer(Integer id) {
        if (filiereRepository.existsById(id)){
            filiereRepository.deleteById(id);
            return "Filieres supprimer";
        }else {
            return "Filiere non trouvée";
        }
    }
}
