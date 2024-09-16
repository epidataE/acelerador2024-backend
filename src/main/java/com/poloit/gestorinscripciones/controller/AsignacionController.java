package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/equipos")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @PostMapping("/asignar/{equipoId}/{desarrolladores}/{uxParticipantes}/{qaParticipantes}")
    public ResponseEntity<String> asignarParticipantesAEquipo(
            @PathVariable Long equipoId,
            @PathVariable int desarrolladores,
            @PathVariable int uxParticipantes,
            @PathVariable int qaParticipantes
    ) {
        asignacionService.asignarParticipantesAEquipo(equipoId, desarrolladores, uxParticipantes, qaParticipantes);
        return ResponseEntity.ok("Participantes asignados al equipo automáticamente.");
    }


}

