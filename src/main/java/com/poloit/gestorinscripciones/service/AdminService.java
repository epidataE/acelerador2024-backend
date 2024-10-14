package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.model.Admin;
import com.poloit.gestorinscripciones.model.Rol;

import com.poloit.gestorinscripciones.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin crearAdmin(Admin admin) {
        admin.setRol(Rol.ADMIN); // Asegúrate de establecer el rol como ADMIN
        return adminRepository.save(admin);
    }

    public List<Admin> mostrarAdmins() {
        return adminRepository.findAll().stream()
                .filter(user -> user.getRol() == Rol.ADMIN)
                .toList();
    }

    public Admin encontrarAdminPorId(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public void eliminarAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
