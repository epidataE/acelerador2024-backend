package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void crearMentor(@RequestBody User user, @RequestParam Long rolId, @RequestParam Long empresaId){
        userService.crearUser(user, rolId, empresaId);
    }
    @GetMapping()
    public List<User> mostrarMentores(){
        return userService.mostrarTodos().stream()
                .filter(user -> user.getRol().getNombre().equals("Mentor"))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Optional<User> mentorId(@PathVariable Long id){
        return userService.userId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarMentor(@PathVariable Long id){
        userService.eliminarUser(id);
    }
    @PutMapping("/{id}")
    public User actualizarMentor(@PathVariable Long id, @RequestBody User user){
        return userService.actualizarUser(id, user);
    }
}
