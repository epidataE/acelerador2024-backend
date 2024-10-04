package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.Mensaje;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.repository.MensajeRepository;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Autowired
    private UserRepository userRepository;

    // Método para enviar un mensaje
    public Mensaje enviarMensaje(Long remitenteId, Long destinatarioId, String contenido) {
        User remitente = userRepository.findById(remitenteId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User destinatario = userRepository.findById(destinatarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Mensaje mensaje = new Mensaje();
        mensaje.setRemitente(remitente);
        mensaje.setDestinatario(destinatario);
        mensaje.setContenido(contenido);
        mensaje.setFechaEnvio(LocalDateTime.now());

        return mensajeRepository.save(mensaje);
    }

    // Método para obtener mensajes recibidos por un usuario
    public List<Mensaje> obtenerMensajesRecibidos(Long usuarioId) {
        return mensajeRepository.findByDestinatario_Id(usuarioId);
    }

    // Método para obtener mensajes enviados por un usuario
    public List<Mensaje> obtenerMensajesEnviados(Long usuarioId) {
        return mensajeRepository.findByRemitente_Id(usuarioId);
    }

    // Método para eliminar un mensaje
    public void eliminarMensaje(Long mensajeId) {
        if (!mensajeRepository.existsById(mensajeId)) {
            throw new RuntimeException("Mensaje no encontrado");
        }
        mensajeRepository.deleteById(mensajeId);
    }
}
