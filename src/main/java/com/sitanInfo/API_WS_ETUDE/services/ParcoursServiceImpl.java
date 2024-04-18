package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Parcours;
import com.sitanInfo.API_WS_ETUDE.repository.ParcoursRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ParcoursServiceImpl implements ParcoursService{

    @Autowired
    private ParcoursRepository parcoursRepository;

    @Override
    public String creer(Parcours parcours) {
         try {
             Parcours parcourExiste = parcoursRepository.getByCode(parcours.getCode());
             if (parcourExiste != null){
                 return "Ce parcours existe deja";
             } else {
                 parcoursRepository.save(parcours);
                 return "Parcours créer avec succés";
             }
         } catch (Exception e){
             e.printStackTrace();
             return "Une erreur est survenue lors de la création de la formation.";
         }
    }

    @Override
    public List<Parcours> lire() {
        return parcoursRepository.findAll();
    }

    @Override
    public Optional<Parcours> findById(Integer id) {
        return parcoursRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, Parcours parcours) {
        try {
            //Recherche le module par son id
            Parcours parcoursModifier = parcoursRepository.findById(id).orElse(null);

            if (parcoursModifier == null) {
                return "Parcours non trouvé";
            }
            //Mettre à jour les informations du module
            parcoursModifier.setCode(parcours.getCode());
            parcoursModifier.setLibelle(parcours.getLibelle());
            parcoursModifier.setEtat(parcours.getEtat());
            parcoursModifier.setCredit(parcours.getCredit());
            parcoursModifier.setSemestreObligatoire(parcours.isSemestreObligatoire());
            parcoursModifier.setTauxProgression(parcours.getTauxProgression());


            //Enregistrer les modifications
            parcoursRepository.save(parcoursModifier);

            return "Parcours modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification du module.";
        }
    }

    @Override
    public String supprimer(Integer id) {
         if (parcoursRepository.existsById(id)){
             parcoursRepository.deleteById(id);
             return "Parcours supprimé";
         } else {
             return "Ce parcours n'existe pas";
         }
    }
}
