package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Composante;
import com.sitanInfo.API_WS_ETUDE.model.Module;
import com.sitanInfo.API_WS_ETUDE.services.ComposanteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ComposanteController {

    @Autowired
    private ComposanteService composanteService;

    @Operation(summary = "Créer une composante")
    @PostMapping("/composante")
    public String create(@RequestBody Composante composante){
        return composanteService.creer(composante);
    }

    @Operation(summary = "Afficher la liste des composantes")
    @GetMapping("/composante")
    public List<Composante> read(){
        return composanteService.lire();
    }

    @Operation(summary = "Afficher une composante")
    @GetMapping("/composante/{id}")
    public Optional<Composante> composante(@PathVariable int id){
        return composanteService.findById(id);
    }

    @Operation(summary = "Modifier une composante")
    @PutMapping("/composante/{id}")
    public String update(@PathVariable int id, @RequestBody Composante composante){
        return composanteService.modifier(id, composante);
    }

    @Operation(summary = "Supprimer une composante")
    @DeleteMapping("/composante/{id}")
    public String delete(@PathVariable int id){
        return composanteService.supprimer(id);
    }
}
