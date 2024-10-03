package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.LoginRequest;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = authService.login(loginRequest.getEmail(), loginRequest.getContrasena());
            return ResponseEntity.ok("LOGIN EXITOSO!!!   " + user.getApellido() + "  " + user.getNombre()+" | "
                    + user.getRol()); // Devuelve el usuario
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}