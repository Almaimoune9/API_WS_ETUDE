package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.FormationsSpecialisation;
import com.sitanInfo.API_WS_ETUDE.repository.ForSpecialisationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ForSpecialisationServiceImpl implements ForSpecialisationService{

    @Autowired
    private ForSpecialisationRepository forSpecialisationRepository;

    @Override
    public String creer(FormationsSpecialisation formationsSpecialisation) {
        try {
            String forExiste = forSpecialisationRepository.getByAbreviation(formationsSpecialisation.getAbreviation());

            if (forExiste != null){
                return "Cette specialisation existe deja";
            } else {
                forSpecialisationRepository.save(formationsSpecialisation);
                return "Specialisation créer avec succés";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Erreur survenue lors de la création de la specialisation";
        }
    }

    @Override
    public List<FormationsSpecialisation> lire() {
        return forSpecialisationRepository.findAll();
    }

    @Override
    public String modifier(Integer id, FormationsSpecialisation formationsSpecialisation) {
        try {
            FormationsSpecialisation forModifier = forSpecialisationRepository.findById(id).orElse(null);
            if (forModifier == null) {
                return "Specialisation non trouvée";
            }
            //Mettre à jour les données
            forModifier.setLibelle(formationsSpecialisation.getLibelle());
            forModifier.setAbreviation(formationsSpecialisation.getAbreviation());

            forSpecialisationRepository.save(forModifier);
            return "Specialisation modifier avec succés";
        } catch (Exception e){
            e.printStackTrace();
            return  "Une erreur est survenu lors de la modification de la specialisation";
    }
    }

    @Override
    public String supprimer(Integer id) {
        if (forSpecialisationRepository.existsById(id)){
            forSpecialisationRepository.deleteById(id);
            return "Specialisation supprimer avec succés";
        } else {
            return "Cette specialisation n'existe pas";
        }
    }

    @Override
    public Optional<FormationsSpecialisation> findByid(Integer id) {
        return forSpecialisationRepository.findById(id);
    }
}
