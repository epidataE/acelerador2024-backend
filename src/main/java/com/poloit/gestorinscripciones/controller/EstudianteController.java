package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.model.Estudiante;
import com.poloit.gestorinscripciones.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

   @PostMapping()
    public void crearEstudiante(@RequestBody Estudiante estudiante, @RequestParam Long cursoId){
        estudianteService.crearEstudiante(estudiante, cursoId);
    }
    @GetMapping()
    public List<Estudiante> mostrarTodos(){
        return estudianteService.mostrarTodos();
    }
    @GetMapping("/{id}")
    public Optional<Estudiante> estudianteId(@PathVariable Long id){
        return estudianteService.estudianteId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id){
        estudianteService.eliminarEstudiante(id);
    }
    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante){
        return estudianteService.actualizarEstudiante(id, estudiante);
    }
}
