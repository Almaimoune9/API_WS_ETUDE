package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.ModesAtomes;
import com.sitanInfo.API_WS_ETUDE.model.Module;
import com.sitanInfo.API_WS_ETUDE.repository.ModeAtomeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ModeAtomeServiceImpl implements ModeAtomeService{

    @Autowired
    private ModeAtomeRepository modeAtomeRepository;

    @Override
    public String creer(ModesAtomes modesAtomes) {
        try {
            ModesAtomes modeExiste = modeAtomeRepository.getByCode(modesAtomes.getCode());
            if (modeExiste != null) {
                return "Ce modeAtome existe deja";
            } else {
                modeAtomeRepository.save(modesAtomes);
                return "ModeAtome créer avec succés";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la création du ModeAtome.";
        }
    }

    @Override
    public List<ModesAtomes> lire() {
        return modeAtomeRepository.findAll();
    }

    @Override
    public Optional<ModesAtomes> findById(Integer id) {
        return modeAtomeRepository.findById(id);
    }

    @Override
    public String modifier(Integer id, ModesAtomes modesAtomes) {
        try {
            //Recherche le modeAtome par son id
            ModesAtomes modeModifier = modeAtomeRepository.findById(id).orElse(null);

            if (modeModifier == null) {
                return "ModeAtome non trouvé";
            }
            //Mettre à jour les informations
            modeModifier.setCode(modesAtomes.getCode());
            modeModifier.setLibelle(modesAtomes.getLibelle());
            modeModifier.setEtat(modesAtomes.getEtat());
            modeModifier.setPayable(modesAtomes.getPayable());
            modeModifier.setPriorite(modesAtomes.getPriorite());



            //Enregistrer les modifications
            modeAtomeRepository.save(modeModifier);

            return "ModeAtome modifier avec succés";
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur est survenue lors de la modification du modeAtome.";
        }
    }

    @Override
    public String supprimer(Integer id) {
        if (modeAtomeRepository.existsById(id)){
            modeAtomeRepository.deleteById(id);
            return "ModeAtome supprimé";
        } else {
            return "Ce mode Atome n'existe pas";
        }
    }
}
