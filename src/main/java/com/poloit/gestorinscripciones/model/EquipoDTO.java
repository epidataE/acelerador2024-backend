package com.poloit.gestorinscripciones.model;

import java.util.List;

public class EquipoDTO {
    private Long id;
    private String nombre;
    private Curso curso;
    private List<UserDTO> usuarios;

    // Constructor
    public EquipoDTO(Long id, String nombre, Curso curso, List<UserDTO> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.usuarios = usuarios;
    }

    public EquipoDTO() {

    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<UserDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UserDTO> usuarios) {
        this.usuarios = usuarios;
    }
}