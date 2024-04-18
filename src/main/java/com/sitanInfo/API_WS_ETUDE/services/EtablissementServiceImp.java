package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Etablissement;
import com.sitanInfo.API_WS_ETUDE.repository.EtablissementRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class EtablissementServiceImp implements EtablissementService{

    @Autowired
    private final EtablissementRepository etablissementRepository;

    @Override
    public String creer(Etablissement etablissement) {
        try {
            Etablissement etablissement1 = etablissementRepository.getByNom(etablissement.getNom());
            if (etablissement1 == null && etablissement.getNom() != null && etablissement.getNom() != "" && etablissement.getNom() != " "){
                etablissementRepository.save(etablissement);
                return "Etablissement créer avec succés";
            } else if (etablissement1 != null){
                return "Etablissement existe deja";
            } else if (etablissement.getNom()==null || etablissement.getNom()== "" || etablissement.getNom() == " "){
                return "Le nom est obligatoire";
            }
        } catch (RuntimeException e){
            return "message"+ e;
        }
        return "Cet etablissement existe deja ";
    }

    @Override
    public List<Etablissement> lire() {
        return etablissementRepository.findAll();
    }

    @Override
    public Etablissement modifier(Integer id, Etablissement etablissement) {
        return etablissementRepository.findById(id)
                .map(e -> {
            e.setAbreviation(etablissement.getAbreviation());
            e.setCode(etablissement.getCode());
            e.setAdresse(etablissement.getAdresse());
            e.setNom(etablissement.getNom());
            e.setGroupe(etablissement.getGroupe());
            return etablissementRepository.save(e);
                }).orElseThrow(()-> new RuntimeException(("Etablissement non trouvé")));
    }

    @Override
    public String supprimer(Integer id) {
        if (etablissementRepository.existsById(id)){
            etablissementRepository.deleteById(id);
            return "Etablissement supprimé avec succés";
        } else {
            return "Cet etablissement n'existe pas";
        }
    }


    @Override
    public Optional<Etablissement> findById(Integer id) {
        return etablissementRepository.findById(id);
    }
}
