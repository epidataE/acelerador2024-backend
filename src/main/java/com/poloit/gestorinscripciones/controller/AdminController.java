package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.model.Admin;
import com.poloit.gestorinscripciones.model.Rol;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping()
    public ResponseEntity<?> crearAdmin(@RequestBody Admin admin) { //devielve un Admin o un String de Error
        // Verificar si el rol es ADMIN
        if (!Rol.ADMIN.equals(admin.getRol())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No es un rol válido para Administrador.");
        }
            Admin nuevoAdmin = adminService.crearAdmin(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAdmin);
        }


    @GetMapping()
    public List<Admin> mostrarAdmins() {
        return adminService.mostrarAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> encontrarAdminPorId(@PathVariable Long id) {
        Admin admin = adminService.encontrarAdminPorId(id);
        return (admin != null) ? ResponseEntity.ok(admin) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdmin(@PathVariable Long id) {
        adminService.eliminarAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
