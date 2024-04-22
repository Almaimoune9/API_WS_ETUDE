package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Module;
import com.sitanInfo.API_WS_ETUDE.repository.ModuleRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ModuleService  {

    @Autowired
    private ModuleRepository moduleRepository;


    public String creer(Module module) {
        try {
            Module moduleExiste = moduleRepository.getByCode(module.getCode());
            if (moduleExiste != null) {
                return "Ce module existe deja";
            } else {
                moduleRepository.save(module);
                return "Module créer avec succés";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la création du module.";
        }
    }


    public List<Module> lire() {
        return moduleRepository.findAll();
    }

    public Optional<Module> findById(Integer id) {
        return moduleRepository.findById(id);
    }


    public String modifier(Integer id, Module module) {
        try {
            //Recherche le module par son id
            Module moduleModifier = moduleRepository.findById(id).orElse(null);

            if (moduleModifier == null) {
                return "Module non trouvé";
            }
            //Mettre à jour les informations du module
            moduleModifier.setCode(module.getCode());
            moduleModifier.setEtat(module.getEtat());
            moduleModifier.setLibelle(module.getLibelle());


            //Enregistrer les modifications
            moduleRepository.save(moduleModifier);

            return "Module modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification du module.";
        }
    }

    public String supprimer(Integer id) {
        if (moduleRepository.existsById(id)){
            moduleRepository.deleteById(id);
            return "Module supprimer avec succés";
        } else {
            return "Ce module n'existe pas";
        }
    }
}
