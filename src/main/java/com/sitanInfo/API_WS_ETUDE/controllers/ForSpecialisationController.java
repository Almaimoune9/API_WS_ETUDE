package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.FormationsSpecialisation;
import com.sitanInfo.API_WS_ETUDE.services.ForSpecialisationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ForSpecialisationController {

    @Autowired
    private ForSpecialisationService forSpecialisationService;

    @Operation(summary = "Créer une specialisation")
    @PostMapping("/specialisation")
    public String create(@RequestBody FormationsSpecialisation formationsSpecialisation){
        return forSpecialisationService.creer(formationsSpecialisation);
    }

    @Operation(summary = "Afficher la liste des specialisations")
    @GetMapping("/specialisation")
    public List<FormationsSpecialisation> read(){
        return forSpecialisationService.lire();
    }

    @Operation(summary = "Afficher une specialisation")
    @GetMapping("/specialisation/{id}")
    public Optional<FormationsSpecialisation> formationsSpecialisation(@PathVariable int id){
        return forSpecialisationService.findByid(id);
    }

    @Operation(summary = "Modifier une specialisation")
    @PutMapping("/specialisation/{id}")
    public String update(@PathVariable int id, @RequestBody FormationsSpecialisation formationsSpecialisation){
        return forSpecialisationService.modifier(id, formationsSpecialisation);
    }

    @Operation(summary = "Supprimer une specialisation")
    @DeleteMapping("/specialisation/{id}")
    public String delete(@PathVariable int id){
        return forSpecialisationService.supprimer(id);
    }
}
