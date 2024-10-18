package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.Mensaje;
import com.poloit.gestorinscripciones.model.MensajeDTO;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.repository.MensajeRepository;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Autowired
    private UserRepository userRepository;

    public MensajeDTO enviarMensaje(Long remitenteId, Long destinatarioId, String contenido) {
        User remitente = userRepository.findById(remitenteId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        User destinatario = userRepository.findById(destinatarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Mensaje mensaje = new Mensaje();
        mensaje.setRemitente(remitente);
        mensaje.setDestinatario(destinatario);
        mensaje.setContenido(contenido);
        mensaje.setFechaEnvio(LocalDateTime.now());

        Mensaje savedMensaje = mensajeRepository.save(mensaje);

        return convertirAMensajeDTO(savedMensaje);
    }

    // Método para obtener mensajes recibidos por un usuario
    public List<MensajeDTO> obtenerMensajesRecibidos(Long usuarioId) {
        List<Mensaje> mensajes = mensajeRepository.findByDestinatario_Id(usuarioId);
        return mensajes.stream()
                .map(this::convertirAMensajeDTO)
                .collect(Collectors.toList());
    }

    // Método para obtener mensajes enviados por un usuario
    public List<MensajeDTO> obtenerMensajesEnviados(Long usuarioId) {
        List<Mensaje> mensajes = mensajeRepository.findByRemitente_Id(usuarioId);
        return mensajes.stream()
                .map(this::convertirAMensajeDTO)
                .collect(Collectors.toList());
    }

    // Método para eliminar un mensaje
    public void eliminarMensaje(Long mensajeId) {
        if (!mensajeRepository.existsById(mensajeId)) {
            throw new RuntimeException("Mensaje no encontrado");
        }
        mensajeRepository.deleteById(mensajeId);
    }

     //Método privado para convertir Mensaje a MensajeDTO
     private MensajeDTO convertirAMensajeDTO(Mensaje mensaje) {
         MensajeDTO dto = new MensajeDTO();
         dto.setId(mensaje.getId());

         // Concatenar nombre y apellido del remitente
         dto.setRemitenteNombre(mensaje.getRemitente().getNombre() + " " + mensaje.getRemitente().getApellido());

         dto.setRemitenteId(mensaje.getRemitente().getId());

         // Concatenar nombre y apellido del destinatario
         dto.setDestinatarioNombre(mensaje.getDestinatario().getNombre() + " " + mensaje.getDestinatario().getApellido());

         dto.setDestinatarioId(mensaje.getDestinatario().getId());

         dto.setContenido(mensaje.getContenido());
         dto.setFechaEnvio(mensaje.getFechaEnvio());

         return dto;
     }

}
