package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.TypeAtome;
import com.sitanInfo.API_WS_ETUDE.services.TypeAtomeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
public class TypeAtomeController {

    @Autowired
    private TypeAtomeService typeAtomeService;

    @Operation(summary = "Créer un typeAtome")
    @PostMapping("/typeAtome")
    public String create(@RequestBody TypeAtome typeAtome){
        return typeAtomeService.creer(typeAtome);
    }

    @Operation(summary = "Afficher la liste des typeAtome")
    @GetMapping("/typeAtome")
    public List<TypeAtome> read(){
        return typeAtomeService.lire();
    }

    @Operation(summary = "Afficher un typeAtome")
    @GetMapping("/typeAtome/{id}")
    public Optional<TypeAtome> typeAtome(@PathVariable int id){
        return typeAtomeService.findById(id);
    }

    @Operation(summary = "Modifier un typeAtome")
    @PutMapping("/typeAtome/{id}")
    public String update(@PathVariable int id, @RequestBody TypeAtome typeAtome){
        return typeAtomeService.modifier(id, typeAtome);
    }

    @Operation(summary = "Supprimer un typeAtome")
    @DeleteMapping("/typeAtome/{id}")
    public String delete(@PathVariable int id){
        return typeAtomeService.supprimer(id);
    }
}
