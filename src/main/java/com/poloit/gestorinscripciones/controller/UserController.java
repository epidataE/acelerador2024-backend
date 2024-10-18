package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.*;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/buscarPorEmail")
    public ResponseEntity<UserDTO> buscarPorEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setNombre(user.getNombre());
            userDTO.setApellido(user.getApellido());
            return ResponseEntity.ok(userDTO);
        }

        return ResponseEntity.notFound().build();
    }
}
