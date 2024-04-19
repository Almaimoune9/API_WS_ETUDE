package com.sitanInfo.API_WS_ETUDE.services;

import com.sitanInfo.API_WS_ETUDE.model.AnneeAcademique;
import com.sitanInfo.API_WS_ETUDE.repository.AnneeAcademiqueRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class AnneeAcademiqueServiceImpl implements AnneeAcademiqueService {

    @Autowired
    private AnneeAcademiqueRepository anneeAcademiqueRepository;

    @Override
    public AnneeAcademique creerAnneeAcademique(AnneeAcademique anneeAcademique) {
        //Verifier si  la date est en cours
        Date dateActuelle = new Date();
        try {
            if (anneeAcademique.getDateDeb().after(dateActuelle)) {
                //Verifie la durée entre les dates
                long differenceJours = Duration.between(anneeAcademique.getDateDeb().toInstant(), anneeAcademique.getDateFin().toInstant()).toDays();
                if (differenceJours <= 365) {
                    return anneeAcademiqueRepository.save(anneeAcademique);
                } else {
                    throw new IllegalArgumentException("La durée entre la dateDebut et la date de fin est maximum 365jours.");
                }
            } else {
                throw new IllegalArgumentException("La date de début doit être en cours.");
            }
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    @Override
    public List<AnneeAcademique> lire() {
        return anneeAcademiqueRepository.findAll();
    }

    @Override
    public Optional<AnneeAcademique> findById(Integer id) {
        return anneeAcademiqueRepository.findById(id);
    }

    @Override
    public String supprimer(Integer id) {
        if (anneeAcademiqueRepository.existsById(id)){
            anneeAcademiqueRepository.deleteById(id);
            return "Année academique supprimée";
        }else {
            return "Année academique non trouvée";
        }
    }
}
