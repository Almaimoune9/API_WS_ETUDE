package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Filieres;
import com.sitanInfo.API_WS_ETUDE.services.FiliereService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class FiliereController {

    @Autowired
    private FiliereService filiereService;

    @Operation(summary = "Créer une filiere")
    @PostMapping("/filiere")
    public String create(@RequestBody Filieres filieres){
        return filiereService.creer(filieres);
    }

    @Operation(summary = "Afficher la liste des filiere")
    @GetMapping("/filiere")
    public List<Filieres> read(){
        return filiereService.lire();
    }

    @Operation(summary = "Afficher une filiere")
    @GetMapping("/filiere/{id}")
    public Optional<Filieres> filieres(@PathVariable int id){
        return filiereService.findById(id);
    }

    @Operation(summary = "Modifier une filiere")
    @PutMapping("/filiere/{id}")
    public String update(@PathVariable int id, @RequestBody Filieres filieres){
        return filiereService.modifier(id, filieres);
    }

    @Operation(summary = "Supprimer une filiere")
    @DeleteMapping("/filiere/{id}")
    public String delete(@PathVariable int id){
        return filiereService.supprimer(id);
    }
}
