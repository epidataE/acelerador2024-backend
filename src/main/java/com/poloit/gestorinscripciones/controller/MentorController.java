package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/mentores")
public class MentorController {
    @Autowired
    MentorService mentorService;

    @PostMapping()
    public void crearMentor(@RequestBody Mentor mentor, @RequestParam Long cursoId){
        mentorService.crearMentor(mentor, cursoId);
    }
    @GetMapping()
    public List<Mentor> mostrarTodos(){
        return mentorService.mostrarTodos();
    }
    @GetMapping("/{id}")
    public Optional<Mentor> mentorId(@PathVariable Long id){
        return mentorService.mentorId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarMentor(@PathVariable Long id){
        mentorService.eliminarMentor(id);
    }
    @PutMapping("/{id}")
    public Mentor actualizarMentor(@PathVariable Long id, @RequestBody Mentor mentor){
        return mentorService.actualizarMentor(id, mentor);
    }
}
