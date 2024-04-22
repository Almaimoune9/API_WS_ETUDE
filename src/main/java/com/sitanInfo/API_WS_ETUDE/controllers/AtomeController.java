package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Atomes;
import com.sitanInfo.API_WS_ETUDE.services.AtomeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AtomeController {

    @Autowired
    private AtomeService atomeService;

    @Operation(summary = "Créer un atome")
    @PostMapping("/atome")
    public String create(@RequestBody Atomes atomes){
        return atomeService.creer(atomes);
    }

    @Operation(summary = "Afficher la liste des atome")
    @GetMapping("/atome")
    public List<Atomes> read(){
        return atomeService.lire();
    }

    @Operation(summary = "Afficher un atome")
    @GetMapping("/atome/{id}")
    public Optional<Atomes> atome(@PathVariable int id){
        return atomeService.findById(id);
    }

    @Operation(summary = "Modifier un atome")
    @PutMapping("/atome/{id}")
    public String update(@PathVariable int id, @RequestBody Atomes atomes){
        return atomeService.modifier(id, atomes);
    }

    @Operation(summary = "Supprimer un atome")
    @DeleteMapping("/atome/{id}")
    public String delete(@PathVariable int id){
        return atomeService.supprimer(id);
    }
}
