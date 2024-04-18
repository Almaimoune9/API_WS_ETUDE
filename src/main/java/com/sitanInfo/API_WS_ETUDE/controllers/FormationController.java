package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Formation;
import com.sitanInfo.API_WS_ETUDE.model.Module;
import com.sitanInfo.API_WS_ETUDE.services.FormationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @Operation(summary = "Créer une formation")
    @PostMapping("/formation")
    public String create(@RequestBody Formation formation){
        return formationService.creer(formation);
    }

    @Operation(summary = "Afficher la liste des formations")
    @GetMapping("/formation")
    public List<Formation> read(){
        return formationService.lire();
    }

    @Operation(summary = "Afficher une formation")
    @GetMapping("/formation/{id}")
    public Optional<Formation> formation(@PathVariable int id){
        return formationService.findById(id);
    }

    @Operation(summary = "Modifier une formation")
    @PutMapping("/formation/{id}")
    public String update(@PathVariable int id, @RequestBody Formation formation){
        return formationService.modifier(id, formation);
    }

    @Operation(summary = "Supprimer une formation")
    @DeleteMapping("/formation/{id}")
    public String delete(@PathVariable int id){
        return formationService.supprimer(id);
    }
}
