package com.poloit.gestorinscripciones.model;

import jakarta.persistence.*;


@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String contacto;
    @Enumerated(EnumType.STRING)
    private TipoEntidad tipoEntidad;

    // Constructor por defecto
    public Empresa() {
    }

    public Empresa(String nombre, String descripcion, String contacto, TipoEntidad tipoEntidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contacto = contacto;
        this.tipoEntidad = tipoEntidad;

    }

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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public TipoEntidad getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(TipoEntidad tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }
}
