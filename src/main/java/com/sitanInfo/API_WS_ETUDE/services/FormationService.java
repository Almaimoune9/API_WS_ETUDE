package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Formation;
import com.sitanInfo.API_WS_ETUDE.model.Habilitation;
import com.sitanInfo.API_WS_ETUDE.repository.FormationRepository;
import com.sitanInfo.API_WS_ETUDE.repository.HabilitationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class FormationService{

    @Autowired
    private  FormationRepository formationRepository;

    @Autowired
    private HabilitationRepository habilitationRepository;

    public String creer(Formation formation, Date debutHabilitation, Date finHabilitation) {
        try {
            Formation formationExiste = formationRepository.getByCode(formation.getCode());
            if (formationExiste != null){
                return "La formation existe déjà";
            } else {
                Habilitation habilitation = new Habilitation();

                habilitation.setDebutHabilitation(debutHabilitation);
                habilitation.setFinHabilitation(finHabilitation);

                formation.setHabilitation(habilitation);


                formationRepository.save(formation);
                return "Formation créer";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur est survenue lors de la création de la formation.";
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
            //Rechercher la formation par son id
            Formation formationExiste = formationRepository.findById(id).orElse(null);

            if (formationExiste == null){
                return "La formation non trouvée";
            }
            //Mettre à jour les données
            formationExiste.setDepart(formation.getDepart());
            formationExiste.setCode(formation.getCode());
            formationExiste.setEtat(formation.getEtat());
            formationExiste.setLibelle(formation.getLibelle());
            formation.setArrivee(formation.getArrivee());
            /*formationExiste.setDebutHabilitation(formation.getDebutHabilitation());
            formationExiste.setFinHabilitation(formation.getFinHabilitation());*/

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
