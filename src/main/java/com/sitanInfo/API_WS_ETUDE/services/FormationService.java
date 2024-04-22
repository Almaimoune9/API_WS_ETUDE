package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Formation;
import com.sitanInfo.API_WS_ETUDE.repository.FormationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class FormationService{

    @Autowired
    private final FormationRepository formationRepository;

    public String creer(Formation formation) {
        try {
            Formation formationExiste = formationRepository.getByCode(formation.getCode());
            if (formationExiste != null){
                return "La formation existe déjà";
            } else {
                formationRepository.save(formation);
                return "Formation créer";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "ne erreur est survenue lors de la création de la formation.";
        }
    }

    public List<Formation> lire() {
        return formationRepository.findAll();
    }

    public Optional<Formation> findById(Integer id) {
        return formationRepository.findById(id);
    }

    public String modifier(Integer id, Formation formation) {
        try {
            //Recherche la formation par son id
            Formation formationExiste = formationRepository.findById(id).orElse(null);

            if (formationExiste == null){
                return "La formation non trouvée";
            }
            //Mettre à jour les données
            formationExiste.setSpecialite(formation.getSpecialite());
            formationExiste.setCode(formation.getCode());
            formationExiste.setEtat(formation.getEtat());
            formationExiste.setLibelle(formation.getLibelle());
            formation.setSpecialisation(formation.getSpecialisation());
            formationExiste.setType(formation.getType());

            //Sauvegarde
            formationRepository.save(formationExiste);

            return "Module modifier avec succés";
        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification de la formation.";
        }
    }

    public String supprimer(Integer id) {
        formationRepository.deleteById(id);
        return "Formation supprimer";
    }


}
