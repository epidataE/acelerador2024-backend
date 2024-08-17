package com.poloit.gestorinscripciones.model;

import jakarta.persistence.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Long id;
    String apellido;
    String nombre;
    String email;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Constructor por defecto
    public Estudiante() {
    }

    public Estudiante(String apellido, String nombre, String email){
        this.apellido = apellido;
        this.nombre = nombre;
        this.email=email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
