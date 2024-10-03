package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getContrasena())) { // Asegúrate de comparar contraseñas encriptadas
            return user;
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}
