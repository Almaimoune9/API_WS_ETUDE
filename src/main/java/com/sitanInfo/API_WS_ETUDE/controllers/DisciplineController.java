package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Discipline;
import com.sitanInfo.API_WS_ETUDE.services.DisciplineService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class DisciplineController {

    @Autowired
    private  DisciplineService disciplineService;

    @Operation(summary = "Creer une discipline")
    @PostMapping("/discipline")
    public String create(Discipline discipline){
        return disciplineService.creer(discipline);
    }

    @Operation(summary = "Afficher la liste des disciplines")
    @GetMapping("/discipline")
    public List<Discipline> read(){
        return disciplineService.lire();
    }

    @Operation(summary = "Afficher une discipline")
    @GetMapping("/discipline/{id}")
    public Optional<Discipline> findById(@PathVariable int id){
        return disciplineService.findById(id);
    }

    @Operation(summary = "Supprimer une discipline")
    @DeleteMapping("/discipline/{id}")
    public String delete(@PathVariable int id){
        return disciplineService.supprimer(id);
    }

    @Operation(summary = "Modifier une discipline")
    @PutMapping("/discipline/{id}")
    public Discipline update(@PathVariable int id,@RequestBody Discipline discipline){
        return disciplineService.modifier(id, discipline);
    }
}
