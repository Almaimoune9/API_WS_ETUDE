package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.TypeAtome;
import com.sitanInfo.API_WS_ETUDE.repository.TypeAtomeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class TypeAtomeService{

    @Autowired
    private TypeAtomeRepository typeAtomeRepository;


    public String creer(TypeAtome typeAtome) {
        try {
            TypeAtome typeExiste = typeAtomeRepository.getByCode(typeAtome.getCode());
            if (typeExiste != null) {
                return "Ce typeAtome existe deja";
            } else {
                typeAtomeRepository.save(typeAtome);
                return "Type atome créer avec succés";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la création du typeAtome.";
        }
    }


    public List<TypeAtome> lire() {
        return typeAtomeRepository.findAll();
    }

    public Optional<TypeAtome> findById(Integer id) {
        return typeAtomeRepository.findById(id);
    }


    public String modifier(Integer id, TypeAtome typeAtome) {
        try {
            //Recherche le typeAtome par son id
            TypeAtome typeModifier = typeAtomeRepository.findById(id).orElse(null);

            if (typeModifier == null) {
                return "Type Atome non trouvé";
            }
            //Mettre à jour les informations
            typeModifier.setCode(typeAtome.getCode());
            typeModifier.setEtat(typeAtome.getEtat());
            typeModifier.setDenominateur(typeAtome.getDenominateur());
            typeModifier.setLibelle(typeAtome.getLibelle());
            typeModifier.setPriorite(typeAtome.getPriorite());
            typeModifier.setSeuil(typeAtome.getSeuil());
            typeModifier.setNumerateur(typeAtome.getNumerateur());

            //Enregistrer les modifications
            typeAtomeRepository.save(typeModifier);

            return "TypeAtome modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification du TypeAtome.";
        }
    }

    public String supprimer(Integer id) {
        if (typeAtomeRepository.existsById(id)){
            typeAtomeRepository.deleteById(id);
            return "TypeAtome supprimé";
        } else {
            return "Ce type atome n'existe pas";
        }
    }
}
