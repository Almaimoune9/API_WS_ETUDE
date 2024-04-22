package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.ModesAtomes;
import com.sitanInfo.API_WS_ETUDE.services.ModeAtomeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ModesAtomeController {

    @Autowired
    private ModeAtomeService modeAtomeService;

    @Operation(summary = "Créer un modeAtome")
    @PostMapping("/modeAtome")
    public String create(@RequestBody ModesAtomes modesAtomes){
        return modeAtomeService.creer(modesAtomes);
    }

    @Operation(summary = "Afficher la liste des modeAtome")
    @GetMapping("/modeAtome")
    public List<ModesAtomes> read(){
        return modeAtomeService.lire();
    }

    @Operation(summary = "Afficher un modeAtome")
    @GetMapping("/modeAtome/{id}")
    public Optional<ModesAtomes> modeAtome(@PathVariable int id){
        return modeAtomeService.findById(id);
    }

    @Operation(summary = "Modifier un modeAtome")
    @PutMapping("/modeAtome/{id}")
    public String update(@PathVariable int id, @RequestBody ModesAtomes modesAtomes){
        return modeAtomeService.modifier(id, modesAtomes);
    }

    @Operation(summary = "Supprimer un modeAtome")
    @DeleteMapping("/modeAtome/{id}")
    public String delete(@PathVariable int id){
        return modeAtomeService.supprimer(id);
    }
}
