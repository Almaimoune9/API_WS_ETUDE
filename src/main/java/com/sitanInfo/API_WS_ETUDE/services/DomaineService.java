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
    private DomaineRepository domaineRepository;
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

    public String modifier(Integer id, Domaine domaine) {
        try {
            Domaine domaineModifier = domaineRepository.findById(id).orElse(null);
            if (domaineModifier == null){
                return "Domaine non trouvé";
            }
            //Mettre à jour les données
            domaineModifier.setNom(domaine.getNom());
            domaineModifier.setCode(domaine.getCode());

            //Enregistrer les modifications
            domaineRepository.save(domaineModifier);
            return "Domaine modifier";
        } catch (Exception e){
            e.printStackTrace();
            return "Erreur lors de la modification";
        }
    }

    public String supprimer(Integer id) {
        if (domaineRepository.existsById(id)) {
            domaineRepository.deleteById(id);
            return "Domaine supprimé avec succés";
        }else {
            return "Ce domaine n'existe pas";
        }
    }

    public Optional<Domaine> findByid(Integer id) {
        return domaineRepository.findById(id);
    }
}
