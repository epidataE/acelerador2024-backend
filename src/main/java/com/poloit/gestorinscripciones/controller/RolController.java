package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Programa;
import com.poloit.gestorinscripciones.model.Rol;
import com.poloit.gestorinscripciones.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/roles")
public class RolController {
    @Autowired
    RolService rolService;
    @PostMapping("")

    public void crearRol(@RequestBody Rol rol ){
        rolService.crearRol(rol);
    }

    @GetMapping("")
    public List<Rol> mostrarRol(){
        return rolService.mostrarRol();
    }
    @GetMapping("/{id}")
    public Optional<Rol> rolId(@PathVariable Long id){
        return rolService.rolId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable Long id){
        rolService.eliminarRol(id);;
    }
    @PutMapping("/{id}")
    public Rol actualizarRol(@PathVariable Long id, @RequestBody Rol rol){
        return rolService.actualizarRol(id, rol);
    }

}
