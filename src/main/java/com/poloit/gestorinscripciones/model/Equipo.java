package com.poloit.gestorinscripciones.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String curso;

    //Un equipo puede tener muchos usuarios
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL) //Define el comportamiento de cascada para las operaciones de persistencia.
    // CascadeType.ALL significa que todos los cambios realizadas en la entidad "Team" se
    // aplicarán también a las entidades "User" asociadas
    private List<User> users = new ArrayList<>();
    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
