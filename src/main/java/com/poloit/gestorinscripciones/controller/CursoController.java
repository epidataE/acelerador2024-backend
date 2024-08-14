package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @PostMapping()
    public void crearCurso(@RequestBody Curso curso){
        cursoService.crearCurso(curso);

    }
    @GetMapping()
    public List<Curso> mostrarTodos(){
        return cursoService.mostrarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Curso> cursoId(@PathVariable Long id){
        return cursoService.cursoId(id);
    }

    @PutMapping("/{id}")
        public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso){
            return cursoService.actualizarCurso(id, curso);
        }


    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
    }




}
