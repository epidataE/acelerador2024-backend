package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.model.Estudiante;
import com.poloit.gestorinscripciones.repository.CursoRepository;
import com.poloit.gestorinscripciones.repository.EstudianteRepository;

import model.Mentor;
import repository.MentorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    @Autowired
    MentorRepository mentorRepository;
    @Autowired
    CursoRepository cursoRepository;

    public void crearMentor(Mentor mentor, Long cursoId) throws ResourceNotFoundException {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow(()
                -> new ResourceNotFoundException("Curso inexistente", "Curso", "id", cursoId));
        mentor.setCurso(curso);
        mentorRepository.save(mentor);

    }
    public List<Mentor> mostrarTodos() {
        //System.out.println(mentorRepository.findAll());
        return mentorRepository.findAll();
    }
    public Optional<Mentor> mentorId(Long id) throws  ResourceNotFoundException{
        if (mentorRepository.findById(id).isPresent()){
            return mentorRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Mentor", "id", id);
        }
    }

    public void eliminarMentor(Long id){
        if (mentorRepository.findById(id).isPresent()) {
            mentorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Mentor", "id", id);
        }
    }

    public Mentor actualizarMentor(Long id, Mentor mentor) throws ResourceNotFoundException {
        Optional<Mentor> mentorAModificar = mentorRepository.findById(id);
        if (mentorAModificar.isPresent()) {
            Mentor mentorModificado = mentorAModificar.get();
            mentorModificado.setApellido(mentor.getApellido());
            mentorModificado.setNombre(mentor.getNombre());
            mentorModificado.setEmail(mentor.getEmail());
            return mentorRepository.save(mentorModificado);

        } else {
            throw new ResourceNotFoundException("not found", "Mentor", "id", id);
        }
    }
}