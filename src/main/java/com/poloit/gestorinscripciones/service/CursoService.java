package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.model.CursoDTO;
import com.poloit.gestorinscripciones.model.UserDTO;
import com.poloit.gestorinscripciones.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    public List<CursoDTO> obtenerCursosConUsuarios() {
        List<Curso> cursos = cursoRepository.findAll();
        return cursos.stream().map(curso -> {
            CursoDTO dto = new CursoDTO();
            dto.setId(curso.getId());
            dto.setNombre(curso.getNombre());
            dto.setDescripcion(curso.getDescripcion());
            dto.setEstado(curso.isEstado());
            Set<UserDTO> usuariosDto = curso.getUsuarios().stream().map(user -> {
                UserDTO userDto = new UserDTO();
                userDto.setId(user.getId());
                userDto.setApellido(user.getApellido());
                userDto.setNombre(user.getNombre());
                userDto.setEmail(user.getEmail());
                userDto.setRol(user.getRol());
                userDto.setEspecializacion(user.getEspecializacion());
                // No incluir el curso aquí para evitar recursión
                return userDto;
            }).collect(Collectors.toSet());
            dto.setUsuarios(usuariosDto);
            return dto;
        }).collect(Collectors.toList());
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
