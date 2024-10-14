package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.*;
import com.poloit.gestorinscripciones.repository.CursoRepository;
import com.poloit.gestorinscripciones.repository.EmpresaRepository;
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


    public User crearUser(User user, Long empresaId)
        throws ResourceNotFoundException {
        if (user.getRol() == null) {
            throw new IllegalArgumentException("El rol del usuario debe ser especificado");
        }
        Empresa empresa = empresaRepository.findById(empresaId).orElseThrow(() ->
                new ResourceNotFoundException("Empresa no encontrada", "EmpresaSocia", "id", empresaId));
        user.setEmpresa(empresa);
        userRepository.save(user);
        return user;

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

    public List<User> findByEspecializacion(Especializacion especializacion) {
        return userRepository.findByEspecializacion(especializacion);
    }

    public void eliminarUser(Long id){
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
        throw new ResourceNotFoundException("not found", "User", "id", id);
    }
    }

    public User actualizarUser(Long id, User user) throws ResourceNotFoundException {
        User userModificado = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado", "User", "id", id));

        userModificado.setApellido(user.getApellido());
        userModificado.setNombre(user.getNombre());
        userModificado.setEmail(user.getEmail());
        userModificado.setContrasena(user.getContrasena());
        userModificado.setRol(user.getRol());
        userModificado.setEspecializacion(user.getEspecializacion());
        userModificado.setEmpresa(user.getEmpresa());

        return userRepository.save(userModificado);
    }
}
