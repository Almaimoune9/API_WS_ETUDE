package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Matieres;
import com.sitanInfo.API_WS_ETUDE.repository.MatiereRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class MatiereService {

    private final MatiereRepository matiereRepository;

    public String creer(Matieres matieres) {
        try {
            //Verifie si la matiere existe
            String matiereExiste = matiereRepository.getByCode(matieres.getCode());
            if (matiereExiste != null){
                return "La matiere existe deja";
            }else {
                matiereRepository.save(matieres);
                return "Matiere creer";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur est survenue lors de la création de la matiere";
        }
    }

    public List<Matieres> lire() {
        return matiereRepository.findAll();
    }
    public Optional<Matieres> finbyId(Integer id) {
        return matiereRepository.findById(id);
    }

    public Matieres modifier(Integer id, Matieres matieres) {
        return matiereRepository.findById(id)
                .map(ma -> {
                    ma.setCode(matieres.getCode());
                    ma.setEtat(matieres.getEtat());
                    ma.setLibelle(matieres.getLibelle());
                    return matiereRepository.save(ma);
                }).orElseThrow(() -> new RuntimeException(("Matiere non trouvée")));
    }


    public String supprimer(Integer id) {
         matiereRepository.deleteById(id);
         return "Matiere supprimer";
    }
}
