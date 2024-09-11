package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.*;
import com.poloit.gestorinscripciones.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    UserService userService;

   @PostMapping()
   public void crearEstudiante(@RequestBody User user, @RequestParam  Long empresaId){
       userService.crearUser(user, empresaId);
   }


    @GetMapping()
    public List<User> mostrarEstudiantes(){
        return userService.mostrarTodos().stream()
                .filter(user -> user.getRol() == Rol.ESTUDIANTE)
                .collect(Collectors.toList());
    }
    @GetMapping("/filtrar")
    public List<User> getEspecialidad(@RequestParam Especializacion especializacion) {
        return userService.findByEspecializacion(especializacion).stream()
                .filter(user -> user.getRol() == Rol.ESTUDIANTE)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> estudianteId(@PathVariable Long id) {
        try {
            Optional<User> estudiante = userService.userId(id);
            return ResponseEntity.ok(estudiante);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        try {
            userService.eliminarUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> actualizarEstudiante(@PathVariable Long id, @RequestBody User user) {
        try {
            User estudianteActualizado = userService.actualizarUser(id, user);
            return ResponseEntity.ok(estudianteActualizado);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
