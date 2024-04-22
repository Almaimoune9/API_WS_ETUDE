package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Domaine;
import com.sitanInfo.API_WS_ETUDE.repository.DomaineRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class DomaineService {

    @Autowired
    private final DomaineRepository domaineRepository;
    public String creer(Domaine domaine) {
        try {
            Domaine domaineExiste = domaineRepository.getByNom(domaine.getNom());
            if (domaineExiste!= null){
                return "Ce domaine existe deja";
            } else {
                domaineRepository.save(domaine);
                return "Domaine créer avec succés";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur est survenue lors de la création du domaine";
        }
    }

    public List<Domaine> lire() {
        return domaineRepository.findAll();
    }

    public Domaine modifier(Integer id, Domaine domaine) {
        return domaineRepository.findById(id)
                .map(d -> {
                    d.setCode(domaine.getCode());
                    d.setNom(domaine.getNom());
                    return domaineRepository.save(d);
                }).orElseThrow(()-> new RuntimeException(("Domaine non trouvé")));
    }

    public String supprimer(Integer id) {
         domaineRepository.deleteById(id);
         return "Domaine supprimé avec succés";
    }

    public Optional<Domaine> findByid(Integer id) {
        return domaineRepository.findById(id);
    }
}
