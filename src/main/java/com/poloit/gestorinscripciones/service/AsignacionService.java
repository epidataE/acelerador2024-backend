package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.Equipo;
import com.poloit.gestorinscripciones.model.Especializacion;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.repository.EquipoRepository;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private UserRepository userRepository;

    public void asignarParticipantesAEquipo(Long equipoId, int cantidadDesarrolladores, int cantidadUx,
                                            int cantidadQa) {
        Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));

        List<User> desarrolladores = userRepository.findByEspecializacion(Especializacion.DESARROLLADOR);
        List<User> uxParticipantes = userRepository.findByEspecializacion(Especializacion.UX_UI);
        List<User> qaParticipantes = userRepository.findByEspecializacion(Especializacion.QA);
       //agrega estudiantes desarrolladores
        int asignados = 0;
        for (User desarrollador : desarrolladores) {
            if (asignados >= cantidadDesarrolladores) {
                break;
            }
            if (desarrollador.getEquipo() == null) { // Solo asignar participantes que no tienen equipo
                desarrollador.setEquipo(equipo);
               userRepository.save(desarrollador);
                asignados++;
            }
        }
        //agrega UX/Ui
        asignados = 0;
        for (User ux : uxParticipantes) {
            if (asignados >= cantidadUx) {
                break;
            }
            if (ux.getEquipo() == null) { // Solo asignar participantes que no tienen equipo
                ux.setEquipo(equipo);
                userRepository.save(ux);
                asignados++;
            }
        }
        //agrega QA
        asignados = 0;
        for (User qa : qaParticipantes) {
            if (asignados >= cantidadQa) {
                break;
            }
            if (qa.getEquipo() == null) { // Solo asignar participantes que no tienen equipo
                qa.setEquipo(equipo);
                userRepository.save(qa);
                asignados++;
            }
        }
    }
}