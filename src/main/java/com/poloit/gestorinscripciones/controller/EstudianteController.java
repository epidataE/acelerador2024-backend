package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void crearEstudiante(@RequestBody User user, @RequestParam Long rolId, @RequestParam Long cursoId){
        userService.crearUser(user, rolId, cursoId);
    }
    @GetMapping()
    public List<User> mostrarEstudiantes(){
       return userService.mostrarTodos().stream()
               .filter(user -> user.getRol().getNombre().equals("Estudiante"))
               .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public Optional<User> estudianteId(@PathVariable Long id){

       return userService.userId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id){
        userService.eliminarUser(id);
    }

    @PutMapping("/{id}")
    public User actualizarEstudiante(@PathVariable Long id, @RequestBody User user){
        return userService.actualizarUser(id, user);
    }
}
