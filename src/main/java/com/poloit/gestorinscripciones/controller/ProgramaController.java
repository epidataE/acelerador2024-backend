package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Empresa;
import com.poloit.gestorinscripciones.model.Programa;
import com.poloit.gestorinscripciones.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/programas")
public class ProgramaController {
    @Autowired
    ProgramaService programaService;

    @PostMapping("")
    public void crearPrograma(@RequestBody Programa programa ){
        programaService.crearPrograma(programa);
    }

    @GetMapping("")
    public List<Programa> mostrarPrograma(){
        return programaService.mostrarPrograma();
    }
    @GetMapping("/{id}")
    public Optional<Programa> programaId(@PathVariable Long id){
        return programaService.programaId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarPrograma(@PathVariable Long id){
        programaService.eliminarPrograma(id);;
    }
    @PutMapping("/{id}")
    public Programa actualizarPrograma(@PathVariable Long id, @RequestBody Programa programa){
        return programaService.actualizarPrograma(id, programa);
    }



}
