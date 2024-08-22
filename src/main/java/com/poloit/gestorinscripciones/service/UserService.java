package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.model.Empresa;
import com.poloit.gestorinscripciones.model.Rol;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.repository.CursoRepository;
import com.poloit.gestorinscripciones.repository.EmpresaRepository;
import com.poloit.gestorinscripciones.repository.RolRepository;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
@Autowired
    UserRepository userRepository;
@Autowired
    CursoRepository cursoRepository;
@Autowired
    EmpresaRepository empresaRepository;
@Autowired
    RolRepository rolRepository;

    public void crearUser(User user, Long rolId, Long cursoId) throws ResourceNotFoundException {

            Rol rol = rolRepository.findById(rolId).orElseThrow(()
                    -> new ResourceNotFoundException("Rol inexistente", "rol", "id", rolId));
            user.setRol(rol);
            if ("Estudiante".equalsIgnoreCase(rol.getNombre())) {
            Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new ResourceNotFoundException("Curso inexistente", "Curso", "id", cursoId));
            user.setCurso(curso);

        } else if ("Mentor".equalsIgnoreCase(rol.getNombre())) {
            Empresa empresa = empresaRepository.findById(cursoId).orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada", "EmpresaSocia", "id", cursoId));
            user.setEmpresa(empresa);
        } else {
            throw new IllegalArgumentException("Rol no soportado: " + rol.getNombre());
        }

        userRepository.save(user);

    }
    public List<User> mostrarTodos() {
        return userRepository.findAll();
    }
    public Optional<User> userId(Long id) throws  ResourceNotFoundException{
        if (userRepository.findById(id).isPresent()){
            return userRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "User", "id", id);
        }
    }

    public void eliminarUser(Long id){
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
        throw new ResourceNotFoundException("not found", "User", "id", id);
    }
    }

    public User actualizarUser(Long id, User user) throws ResourceNotFoundException {
        Optional<User> userAModificar = userRepository.findById(id);
        if (userAModificar.isPresent()) {
            User userModificado = userAModificar.get();
            userModificado.setApellido(user.getApellido());
            userModificado.setNombre(user.getNombre());
            userModificado.setEmail(user.getEmail());
            userModificado.setContrasena(user.getContrasena());
            return userRepository.save(userModificado);

        } else {
            throw new ResourceNotFoundException("not found", "User", "id", id);
        }
    }
}
