package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Grades;
import com.sitanInfo.API_WS_ETUDE.repository.GradeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class GradeServiceImpl implements GradeSevice{

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public String creer(Grades grades) {
        try {
            Grades gradeExiste = gradeRepository.getByCode(grades.getCode());
            if (gradeExiste != null){
                return "Cette grade existe";
            } else {
                gradeRepository.save(grades);
                return "Grade créer";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur est survenue lors de la création du grade";
        }
    }

    @Override
    public List<Grades> lire() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<Grades> findByid(Integer id) {
        return gradeRepository.findById(id);
    }

    @Override
    public String supprimer(Integer id) {
        gradeRepository.deleteById(id);
        return "Grade non trouvée";
    }

    @Override
    public String modifier(Integer id, Grades grades) {
        return null;
    }
}
