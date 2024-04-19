package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.Composante;
import com.sitanInfo.API_WS_ETUDE.repository.ComposanteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ComposanteServiceImpl implements ComposanteService{

    @Autowired
    private ComposanteRepository composanteRepository;

    @Override
    public String creer(Composante composante) {
        try {
            Composante composanteExiste = composanteRepository.getByNom(composante.getNom());
            if (composanteExiste != null){
                return "Cette composante existe deja";
            } else {
                composanteRepository.save(composante);
                return "Composante créer";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "Une erreur s'est produite lors de la création de la composante";
        }
    }

    @Override
    public List<Composante> lire() {
        return composanteRepository.findAll();
    }

    @Override
    public Optional<Composante> findById(Integer id) {
        return composanteRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, Composante composante) {
        try {
            Composante composanteModifier = composanteRepository.findById(id).orElse(null);
            if (composanteModifier == null){
                return "Composante non trouvé";
            }
            //Mettre à jour les données
            composanteModifier.setCode(composante.getCode());
            composanteModifier.setNom(composante.getNom());
            composanteModifier.setDescription(composante.getDescription());

            //Enregistrer les modifications
            composanteRepository.save(composanteModifier);
            return "Composante modifiée";
        } catch (Exception e){
            e.printStackTrace();
            return "Erreur lors de la modification";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (composanteRepository.existsById(id)){
            composanteRepository.deleteById(id);
            return "Composante supprimée";
        }else {
            return "Cette composante n'existe pas";
        }
    }
}
