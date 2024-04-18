package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Module;
import com.sitanInfo.API_WS_ETUDE.model.Parcours;
import com.sitanInfo.API_WS_ETUDE.services.ParcoursService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ParcoursController {

    @Autowired
    private ParcoursService parcoursService;

    @Operation(summary = "Créer un parcours")
    @PostMapping("/parcours")
    public String create(@RequestBody Parcours parcours){
        return parcoursService.creer(parcours);
    }

    @Operation(summary = "Afficher la liste des parcours")
    @GetMapping("/parcours")
    public List<Parcours> read(){
        return parcoursService.lire();
    }

    @Operation(summary = "Afficher un parcours")
    @GetMapping("/parcours/{id}")
    public Optional<Parcours> module(@PathVariable int id){
        return parcoursService.findById(id);
    }

    @Operation(summary = "Modifier un parcours")
    @PutMapping("/parcours/{id}")
    public String update(@PathVariable int id, @RequestBody Parcours parcours){
        return parcoursService.modifier(id, parcours);
    }

    @Operation(summary = "Supprimer un parcours")
    @DeleteMapping("/parcours/{id}")
    public String delete(@PathVariable int id){
        return parcoursService.supprimer(id);
    }
}
