package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Grade;
import com.sitanInfo.API_WS_ETUDE.model.TypeFormation;
import com.sitanInfo.API_WS_ETUDE.repository.GradeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public String creer(Grade grade){
        try {
            Grade gradeExiste = gradeRepository.getByCode(grade.getCode());
            if (gradeExiste != null){
                return "Cette grade existe deja";
            } else {
                gradeRepository.save(grade);
                return "Grade  créer";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "Une erreur s'est produite lors de la creation";
        }
    }

    public String supprimer(Integer id){
        if (gradeRepository.existsById(id)){
            gradeRepository.deleteById(id);
            return "Grade supprimé";
        } else {
            return "Cette grade n'existe pas";
        }
    }
}
