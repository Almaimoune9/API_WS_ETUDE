package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Atomes;
import com.sitanInfo.API_WS_ETUDE.repository.AtomeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AtomeService{

    @Autowired
    private AtomeRepository atomeRepository;

    public String creer(Atomes atomes) {
        atomeRepository.save(atomes);
        return "Atome créer";
    }

    public List<Atomes> lire() {
        return atomeRepository.findAll();
    }


    public Optional<Atomes> findById(Integer id) {
        return atomeRepository.findById(id);
    }

    public String modifier(Integer id, Atomes atomes) {
        try {
            //Recherche l'atome par son id
            Atomes atomeModifier = atomeRepository.findById(id).orElse(null);

            if (atomeModifier == null) {
                return "Atome non trouvé";
            }
            //Mettre à jour les informations de l'atome
            atomeModifier.setSeuil(atomes.getSeuil());
            atomeModifier.setValeur(atomes.getValeur());
            atomeModifier.setGoupePrevu(atomes.getGoupePrevu());
            atomeModifier.setGroupeReel(atomes.getGroupeReel());


            //Enregistrer les modifications
            atomeRepository.save(atomeModifier);

            return "Atome modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de l'atome.";
        }
    }

    public String supprimer(Integer id) {
        if (atomeRepository.existsById(id)){
            atomeRepository.deleteById(id);
            return "Atome supprimer";
        }else {
            return "Cet atome n'existe pas";
        }
    }
}
