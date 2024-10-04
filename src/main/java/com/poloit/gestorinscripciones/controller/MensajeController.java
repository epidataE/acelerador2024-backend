package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Mensaje;
import com.poloit.gestorinscripciones.model.MensajeDTO;
import com.poloit.gestorinscripciones.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @PostMapping("/enviar")
    public Mensaje enviarMensaje(@RequestBody MensajeDTO mensajeDTO) {
        return mensajeService.enviarMensaje(mensajeDTO.getRemitenteId(), mensajeDTO.getDestinatarioId(), mensajeDTO.getContenido());
    }

    @GetMapping("/recibir/{usuarioId}")
    public List<Mensaje> obtenerMensajesRecibidos(@PathVariable Long usuarioId) {
        return mensajeService.obtenerMensajesRecibidos(usuarioId);
    }

    @GetMapping("/enviados/{usuarioId}")
    public List<Mensaje> obtenerMensajesEnviados(@PathVariable Long usuarioId) {
        return mensajeService.obtenerMensajesEnviados(usuarioId);
    }

    @DeleteMapping("/eliminar/{mensajeId}")
    public String eliminarMensaje(@PathVariable Long mensajeId) {
        mensajeService.eliminarMensaje(mensajeId);
        return "{\"mensaje\": \"Mensaje eliminado con éxito.\"}";
    }
}
