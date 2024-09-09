package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.Equipo;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.repository.EquipoRepository;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    private UserRepository userRepository;

    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }
    public Equipo asignarUsuarios(Long equipoId, List<Long> userIds) {
        Equipo equipo = equipoRepository.findById(equipoId).orElseThrow(() ->
                new RuntimeException("Equipo no encontrado"));
        List<User> users = userRepository.findAllById(userIds);
        for (User user : users) {
            user.setEquipo(equipo);
        }
        equipo.getUsers().addAll(users);
        return equipoRepository.save(equipo);
    }
    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

}
