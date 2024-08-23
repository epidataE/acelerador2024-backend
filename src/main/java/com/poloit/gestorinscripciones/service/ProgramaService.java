package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Programa;
import com.poloit.gestorinscripciones.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaService {
    @Autowired
    ProgramaRepository programaRepository;

    public void crearPrograma(Programa programa){

        programaRepository.save(programa);
    }
    public List<Programa> mostrarPrograma(){

        return programaRepository.findAll();
    }
    public Optional<Programa> programaId(Long id) throws ResourceNotFoundException {
        if (programaRepository.findById(id).isPresent()){
            return programaRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Programa", "id", id);
        }
            }
    public void eliminarPrograma(Long id){
        if (programaRepository.findById(id).isPresent()) {
            programaRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Programa", "id", id);
        }
    }
    public Programa actualizarPrograma(Long id, Programa programa) throws ResourceNotFoundException {
        Optional<Programa> programaAModificar = programaRepository.findById(id);
        if (programaAModificar.isPresent()) {
            Programa programaModificado = programaAModificar.get();
            programaModificado.setNombre(programa.getNombre());

            return programaRepository.save(programaModificado);

        } else {
            throw new ResourceNotFoundException("not found", "Programa", "id", id);
        }
    }
}
