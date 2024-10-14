package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;


    public Curso crearCurso (Curso curso) throws ResourceNotFoundException {
           return cursoRepository.save(curso);
    }
    public List<Curso> mostrarTodos() {
        return cursoRepository.findAll();

    }
    public List<Curso> obtenerCursosActivos() {
        return cursoRepository.findByEstado(true);
    }

    public Optional<Curso> cursoId(Long id){
        return cursoRepository.findById(id);
    }

    public void eliminarCurso(Long id){
        cursoRepository.deleteById(id);
    }

    public Curso actualizarCurso(Long id, Curso curso){
        Optional<Curso> cursoAModificar = cursoRepository.findById(id);
        if (cursoAModificar.isPresent()){
            Curso cursoModificado = cursoAModificar.get();
            cursoModificado.setNombre(curso.getNombre());
            cursoModificado.setDescripcion(curso.getDescripcion());
            cursoModificado.setEstado(curso.isEstado());
            return cursoRepository.save(cursoModificado);

        } else {
            throw new RuntimeException("Curso con ID:" + id + " no encontrado!");
        }
    }

}
