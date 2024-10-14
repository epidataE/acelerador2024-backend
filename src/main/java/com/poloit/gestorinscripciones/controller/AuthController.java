package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Admin;
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
            Object account = authService.login(loginRequest.getEmail(), loginRequest.getContrasena());

            // Verificar si el objeto devuelto es un User o un Admin
            if (account instanceof User) {
                User user = (User) account;
                return ResponseEntity.ok(user);// Devuelve el usuario
            } else if (account instanceof Admin) {
                Admin admin = (Admin) account;
                return ResponseEntity.ok(admin);// Devuelve el administrador
            }

            // En caso de que no se reconozca el tipo
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
