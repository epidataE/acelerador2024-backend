package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Rol;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mentores")
public class MentorController {
    @Autowired
    UserService userService;

    @PostMapping()
    public void crearMentor(@RequestBody User user, @RequestParam  Long empresaId){
        userService.crearUser(user, empresaId);
    }

    @GetMapping()
    public List<User> mostrarMentores(){
        return userService.mostrarTodos().stream()
                .filter(user -> user.getRol() == Rol.MENTOR)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> mentorId(@PathVariable Long id){
        try {
            Optional<User> mentor = userService.userId(id);
            return ResponseEntity.ok(mentor);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMentor(@PathVariable Long id){
        try {
            userService.eliminarUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> actualizarMentor(@PathVariable Long id, @RequestBody User user){
        try {
            User mentorActualizado = userService.actualizarUser(id, user);
            return ResponseEntity.ok(mentorActualizado);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
