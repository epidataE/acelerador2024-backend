package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.Admin;
import com.poloit.gestorinscripciones.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.poloit.gestorinscripciones.repository.AdminRepository;
import com.poloit.gestorinscripciones.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;

    public Object login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getContrasena())) { //  comparar contraseñas
            return user;
        }
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && password.equals(admin.getContrasena())) { //  comparar contraseñas
            return admin;
        }

        throw new RuntimeException("Credenciales inválidas");
    }
}

