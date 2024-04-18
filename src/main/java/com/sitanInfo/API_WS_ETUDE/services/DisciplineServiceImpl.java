package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Discipline;
import com.sitanInfo.API_WS_ETUDE.repository.DisciplineRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class DisciplineServiceImpl implements DisciplineService{

    @Autowired
    private final DisciplineRepository disciplineRepository;
    @Override
    public String creer(Discipline discipline) {
        try {
            //Verifie si la discipline existe
            Discipline disExiste = disciplineRepository.getByNom(discipline.getNom());
            if (disExiste != null){
                return "La discipline existe deja";
            } else {
                disciplineRepository.save(discipline);
                return "Discipline créer avec succés";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur est survenue lors de la création de la formation.";
        }
        }

    @Override
    public List<Discipline> lire() {
        return disciplineRepository.findAll();
    }

    @Override
    public Optional<Discipline> findById(Integer id) {
        return disciplineRepository.findById(id);
    }

    @Override
    public Discipline modifier(Integer id, Discipline discipline) {
        return disciplineRepository.findById(id)
                .map(d -> {
                    d.setCode(discipline.getCode());
                    d.setNom(discipline.getNom());
                    return disciplineRepository.save(d);
                }).orElseThrow(()-> new RuntimeException(("Discipline non trouvée")));
    }


    @Override
    public String supprimer(Integer id) {
        disciplineRepository.deleteById(id);
        return "Discipline supprimer";
    }
}
