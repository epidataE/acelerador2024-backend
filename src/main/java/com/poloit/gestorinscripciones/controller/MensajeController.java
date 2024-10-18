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
    public MensajeDTO enviarMensaje(@RequestBody MensajeDTO mensajeDto) {
        return mensajeService.enviarMensaje(mensajeDto.getRemitenteId(),
                mensajeDto.getDestinatarioId(),
                mensajeDto.getContenido());
    }

    @GetMapping("/recibir/{usuarioId}")
    public List<MensajeDTO> obtenerMensajesRecibidos(@PathVariable Long usuarioId) {
        return mensajeService.obtenerMensajesRecibidos(usuarioId);
    }

    @GetMapping("/enviados/{usuarioId}")
    public List<MensajeDTO> obtenerMensajesEnviados(@PathVariable Long usuarioId) {
        return mensajeService.obtenerMensajesEnviados(usuarioId);
    }
}
