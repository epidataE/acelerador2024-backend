package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.Equipo;
import com.poloit.gestorinscripciones.model.Especializacion;
import com.poloit.gestorinscripciones.model.Rol;
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

        List<User> desarrolladores = userRepository.findByRolAndEspecializacion(Rol.ESTUDIANTE, Especializacion.DESARROLLADOR);
        List<User> uxParticipantes = userRepository.findByRolAndEspecializacion(Rol.ESTUDIANTE, Especializacion.UX_UI);
        List<User> qaParticipantes = userRepository.findByRolAndEspecializacion(Rol.ESTUDIANTE, Especializacion.QA);
        //mentores
        List<User> mentoresDesarrolladores = userRepository.findByRolAndEspecializacion(Rol.MENTOR, Especializacion.DESARROLLADOR);
        List<User> mentoresUx = userRepository.findByRolAndEspecializacion(Rol.MENTOR, Especializacion.UX_UI);
        List<User> mentoresQa = userRepository.findByRolAndEspecializacion(Rol.MENTOR, Especializacion.QA);

        // Verifica si hay suficientes participantes en todas las categorías
        if (desarrolladores.size() >= cantidadDesarrolladores &&
                uxParticipantes.size() >= cantidadUx &&
                qaParticipantes.size() >= cantidadQa) {


            // Asigna desarrolladores
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

            // Asigna UX/UI
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

            // Asigna QA
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

            // Asigna un mentor único por equipo
            User mentorAsignado = null;
            for (User mentor : mentoresDesarrolladores) {
                if (mentor.getEquipo() == null) {
                    mentor.setEquipo(equipo);
                    userRepository.save(mentor);
                    mentorAsignado = mentor;
                    break;
                }
            }

            if (mentorAsignado == null) {
                for (User mentor : mentoresUx) {
                    if (mentor.getEquipo() == null) {
                        mentor.setEquipo(equipo);
                        userRepository.save(mentor);
                        mentorAsignado = mentor;
                        break;
                    }
                }
            }

            if (mentorAsignado == null) {
                for (User mentor : mentoresQa) {
                    if (mentor.getEquipo() == null) {
                        mentor.setEquipo(equipo);
                        userRepository.save(mentor);
                        mentorAsignado = mentor;
                        break;
                    }
                }
            }

            if (mentorAsignado == null) {
                System.out.println("No hay mentores disponibles para asignar.");
            }

        } else {
            // Envía una alerta si no hay suficientes participantes
            //System.out.println("No hay suficientes participantes en una o mas categorias.");
            throw new RuntimeException("No hay suficientes participantes en una o mas categorias.");
        }
        }

    }
