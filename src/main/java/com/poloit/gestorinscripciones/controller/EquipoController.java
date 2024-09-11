package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Equipo;
import com.poloit.gestorinscripciones.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    @Autowired
    EquipoService equipoService;

    @PostMapping
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoService.crearEquipo(equipo);
    }

    @GetMapping
    public List<Equipo> listarEquipos() {
        return equipoService.listarEquipos();
    }


}
