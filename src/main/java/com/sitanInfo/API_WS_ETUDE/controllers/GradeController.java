package com.sitanInfo.API_WS_ETUDE.controllers;

import com.sitanInfo.API_WS_ETUDE.model.Grades;
import com.sitanInfo.API_WS_ETUDE.services.GradeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Operation(summary = "Créer une grade")
    @PostMapping("/grade")
    public String creer(@RequestBody Grades grades){
        return gradeService.creer(grades);
    }

    @Operation(summary = "Afficher la liste des grades")
    @GetMapping("/grade")
    public List<Grades> read(){
        return gradeService.lire();
    }

    @Operation(summary = "Afficher une grade")
    @GetMapping("/grade/{id}")
    public Optional<Grades> grades(@PathVariable int id){
        return gradeService.findByid(id);
    }

    @Operation(summary = "Modifier une grade")
    @PutMapping("/grade/{id}")
    public String update(@PathVariable int id, @RequestBody Grades grades){
        return gradeService.modifier(id, grades);
    }

    @Operation(summary = "Supprimer une grade")
    @DeleteMapping("/grade/{id}")
    public String delete(@PathVariable int id){
        return gradeService.supprimer(id);
    }
}
