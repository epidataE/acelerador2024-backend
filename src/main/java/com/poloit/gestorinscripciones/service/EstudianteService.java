package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.model.Estudiante;
import com.poloit.gestorinscripciones.repository.CursoRepository;
import com.poloit.gestorinscripciones.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
@Autowired
EstudianteRepository estudianteRepository;
@Autowired
    CursoRepository cursoRepository;

    public void crearEstudiante(Estudiante estudiante, Long cursoId) throws ResourceNotFoundException {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(()
                -> new ResourceNotFoundException("Curso inexistente", "Curso", "id", cursoId));
        estudiante.setCurso(curso);
        estudianteRepository.save(estudiante);

    }
    public List<Estudiante> mostrarTodos() {
        //System.out.println(estudianteRepository.findAll());
        return estudianteRepository.findAll();
    }
    public Optional<Estudiante> estudianteId(Long id) throws  ResourceNotFoundException{
        if (estudianteRepository.findById(id).isPresent()){
            return estudianteRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Estudiante", "id", id);
        }
    }

    public void eliminarEstudiante(Long id){
        if (estudianteRepository.findById(id).isPresent()) {
            estudianteRepository.deleteById(id);
        } else {
        throw new ResourceNotFoundException("not found", "Estudiante", "id", id);
    }
    }

    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) throws ResourceNotFoundException {
        Optional<Estudiante> estudianteAModificar = estudianteRepository.findById(id);
        if (estudianteAModificar.isPresent()) {
            Estudiante estudianteModificado = estudianteAModificar.get();
            estudianteModificado.setApellido(estudiante.getApellido());
            estudianteModificado.setNombre(estudiante.getNombre());
            estudianteModificado.setEmail(estudiante.getEmail());
            return estudianteRepository.save(estudianteModificado);

        } else {
            throw new ResourceNotFoundException("not found", "Estudiante", "id", id);
        }
    }
}
