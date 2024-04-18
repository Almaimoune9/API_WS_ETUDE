package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Matieres;
import com.sitanInfo.API_WS_ETUDE.services.MatiereService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    @Operation(summary = "Creer une matiere")
    @PostMapping("/matiere")
    public String create(@RequestBody Matieres matieres){
        return matiereService.creer(matieres);
    }

    @Operation(summary = "Afficher la liste des matieres")
    @GetMapping("/matiere")
    public List<Matieres> read(){
        return matiereService.lire();
    }

    @Operation(summary = "Afficher une matiere")
    @GetMapping("/matiere/{id}")
    public Optional<Matieres> matieres(@PathVariable int id){
        return matiereService.finbyId(id);
    }

    @Operation(summary = "Supprimer une matiere")
    @DeleteMapping("/matiere/{id}")
    public String delete(@PathVariable int id){
        return matiereService.supprimer(id);
    }

    @PutMapping("/matiere/{id}")
    public Matieres update(@PathVariable int id, @RequestBody Matieres matieres){
        return matiereService.modifier(id, matieres);
    }
}
