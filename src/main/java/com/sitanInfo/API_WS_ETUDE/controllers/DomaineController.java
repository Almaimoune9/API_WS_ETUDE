package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Discipline;
import com.sitanInfo.API_WS_ETUDE.model.Domaine;
import com.sitanInfo.API_WS_ETUDE.services.DomaineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( value = "/api")
public class DomaineController {

    @Autowired
    private DomaineService domaineService;

    @Operation(summary = "Créer un domaine")
    @PostMapping("/domaine")
    public String create(@RequestBody Domaine domaine){
        return domaineService.creer(domaine);
    }

    @Operation(summary = "Afficher la liste des domaines")
    @GetMapping("/domaine")
    public List<Domaine> read(){
        return  domaineService.lire();
    }

    @Operation(summary = "Afficher un domaine")
    @GetMapping("/domaine/{id}")
    public Optional<Domaine> domaine(@PathVariable int id){
        return domaineService.findByid(id);
    }

    @Operation(summary = "Modifier un domaine")
    @PutMapping("/domaine/{id}")
    public String update(@PathVariable int id, @RequestBody Domaine domaine){
        return domaineService.modifier( id, domaine);
    }

    @Operation(summary = "Supprimer un domaine")
    @DeleteMapping("/domaine/{id}")
    public String delete(@PathVariable int id){
        return domaineService.supprimer(id);
    }
}
