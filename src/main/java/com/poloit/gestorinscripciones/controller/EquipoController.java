package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.*;
import com.poloit.gestorinscripciones.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    EquipoService equipoService;

//    @PostMapping
//    public Equipo crearEquipo(@RequestBody Equipo equipo) {
//        return equipoService.crearEquipo(equipo);
//    }
@PostMapping()
public ResponseEntity<Equipo> crearEquipo(@RequestParam Long cursoId, @RequestBody EquipoDTO equipoDTO) {
    try {
        Equipo equipoCreado = equipoService.crearEquipo(cursoId, equipoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoCreado);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(null);
    }
}


    @GetMapping("/todos")
    public List<Equipo> listarEquipos() {
        return equipoService.listarEquipos();
    }
    @GetMapping("")
    public ResponseEntity<List<EquipoDTO>> listarEquiposConUsuarios() {
        List<EquipoDTO> equipos = equipoService.obtenerEquiposConUsuarios();
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Equipo>> equipoId(@PathVariable Long id) {
        try {
            Optional<Equipo> equipo = equipoService.equipoId(id);
            return ResponseEntity.ok(equipo);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable Long id){
        equipoService.eliminarEquipo(id);
    }


}
