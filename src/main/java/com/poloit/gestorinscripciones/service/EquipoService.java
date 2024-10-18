package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.*;
import com.poloit.gestorinscripciones.repository.CursoRepository;
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
    @Autowired
    private CursoRepository cursoRepository;


    public Equipo crearEquipo(Long cursoId, EquipoDTO equipoDTO) {
        // Obtener el curso por ID
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Crear un nuevo equipo y asignar el curso
        Equipo equipo = new Equipo();
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setCurso(curso); // Asignar el curso al equipo

        // Guardar el equipo en la base de datos
        equipoRepository.save(equipo);
        return equipo;
    }


    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

public List<EquipoDTO> obtenerEquiposConUsuarios() {
    List<Equipo> equipos = equipoRepository.findAll();
    return equipos.stream().map(equipo -> {
        EquipoDTO dto = new EquipoDTO();
        dto.setId(equipo.getId());
        dto.setNombre(equipo.getNombre());
        dto.setCurso(equipo.getCurso());
        // Mapear usuarios a UserDTO
        List<UserDTO> usuariosDto = equipo.getUsuarios().stream().map(user -> {
            UserDTO userDto = new UserDTO();
            userDto.setId(user.getId());
            userDto.setApellido(user.getApellido());
            userDto.setNombre(user.getNombre());
            userDto.setEmail(user.getEmail());
            userDto.setRol(user.getRol());
            userDto.setEspecializacion(user.getEspecializacion());

            // Si necesitas incluir el curso del usuario, asegúrate de manejarlo aquí
            if (user.getCurso() != null) {
                CursoDTO cursoDTO = new CursoDTO();
                cursoDTO.setId(user.getCurso().getId());
                cursoDTO.setNombre(user.getCurso().getNombre());
                userDto.setCurso(cursoDTO);
            } else {
                userDto.setCurso(null);
            }

            userDto.setEmpresaNombre(user.getEmpresa().getNombre()); // entidad Empresa
            return userDto;
        }).collect(Collectors.toList());

        dto.setUsuarios(usuariosDto);
        return dto;
    }).collect(Collectors.toList());
}

    public Optional<Equipo> equipoId(Long id) throws ResourceNotFoundException {
        if (equipoRepository.findById(id).isPresent()){
            return equipoRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "User", "id", id);
        }
    }
    public void eliminarEquipo(Long id){
        if (equipoRepository.findById(id).isPresent()) {
           equipoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Equipo", "id", id);
        }
    }


}
