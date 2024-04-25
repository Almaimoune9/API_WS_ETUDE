package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.TypeFormation;
import com.sitanInfo.API_WS_ETUDE.repository.TypeFormationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class TypeFormationService {

    @Autowired
    private TypeFormationRepository typeFormationRepository;

    public String creer(TypeFormation typeFormation){
        try {
            TypeFormation typeFormationExiste = typeFormationRepository.getByType(typeFormation.getType());
            if (typeFormationExiste != null){
                return "Ce type de formation existe deja";
            } else {
                typeFormationRepository.save(typeFormation);
                return "Type formation créer";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Une erreur s'est produite lors de la creation";
        }
    }

    public String supprimer(Integer id){
        if (typeFormationRepository.existsById(id)){
            typeFormationRepository.deleteById(id);
            return "Type de formation supprimé";
        } else {
            return "Ce type de formation n'existe pas";
        }
    }
}
