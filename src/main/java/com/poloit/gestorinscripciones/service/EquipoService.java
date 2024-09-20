package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Empresa;
import com.poloit.gestorinscripciones.model.Equipo;
import com.poloit.gestorinscripciones.model.TipoEntidad;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.repository.EquipoRepository;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    private UserRepository userRepository;


    public Equipo crearEquipo(Equipo equipo) {

        // Guardar el equipo
        return equipoRepository.save(equipo);
    }


    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> equipoId(Long id) throws ResourceNotFoundException {
        if (equipoRepository.findById(id).isPresent()){
            return equipoRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "User", "id", id);
        }
    }


}
