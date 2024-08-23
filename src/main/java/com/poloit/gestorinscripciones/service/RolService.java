package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Programa;
import com.poloit.gestorinscripciones.model.Rol;
import com.poloit.gestorinscripciones.repository.ProgramaRepository;
import com.poloit.gestorinscripciones.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public void crearRol (Rol rol){

        rolRepository.save(rol);
    }
    public List<Rol> mostrarRol(){

        return rolRepository.findAll();
    }
    public Optional<Rol> rolId(Long id) throws ResourceNotFoundException {
        if (rolRepository.findById(id).isPresent()){
            return rolRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Rol", "id", id);
        }
    }
    public void eliminarRol(Long id){
        if (rolRepository.findById(id).isPresent()) {
            rolRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Rol", "id", id);
        }
    }
    public Rol actualizarRol(Long id, Rol rol) throws ResourceNotFoundException {
        Optional<Rol> rolAModificar = rolRepository.findById(id);
        if (rolAModificar.isPresent()) {
            Rol rolModificado = rolAModificar.get();
            rolModificado.setNombre(rol.getNombre());

            return rolRepository.save(rolModificado);

        } else {
            throw new ResourceNotFoundException("not found", "Rol", "id", id);
        }
    }
}

