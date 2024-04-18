package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Module;
import com.sitanInfo.API_WS_ETUDE.services.ModuleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @Operation(summary = "Créer un module")
    @PostMapping("/module")
    public String create(@RequestBody Module module){
        return moduleService.creer(module);
    }

    @Operation(summary = "Afficher la liste des modules")
    @GetMapping("/module")
    public List<Module> read(){
       return moduleService.lire();
    }

    @Operation(summary = "Afficher un module")
    @GetMapping("/module/{id}")
    public Optional<Module> module(@PathVariable int id){
        return moduleService.findById(id);
    }

    @Operation(summary = "Modifier un module")
    @PutMapping("/module/{id}")
    public String update(@PathVariable int id, @RequestBody Module module){
        return moduleService.modifier(id, module);
    }

    @Operation(summary = "Supprimer un module")
    @DeleteMapping("/module/{id}")
    public String delete(@PathVariable int id){
        return moduleService.supprimer(id);
    }
}
