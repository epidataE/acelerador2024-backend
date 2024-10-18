package com.poloit.gestorinscripciones.model;

import java.util.Set;

public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private Set<UserDTO> usuarios;

    public CursoDTO(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public CursoDTO() {

    }

    // Constructor, Getters y Setters

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Set<UserDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UserDTO> usuarios) {
        this.usuarios = usuarios;
    }
}
