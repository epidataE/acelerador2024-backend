package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Equipo;
import com.poloit.gestorinscripciones.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    EquipoService equipoService;
    @PostMapping()
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoService.crearEquipo(equipo);
    }
    @PostMapping("/{equipoId}/usuarios")
    public Equipo asignarUsuarios(@PathVariable Long equipoId, @RequestBody List<Long> userIds) {
        return equipoService.asignarUsuarios(equipoId, userIds);
    }
    @GetMapping
    public List<Equipo> listarEquipos() {
        return equipoService.listarEquipos();
    }


}
