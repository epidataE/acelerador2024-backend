package com.poloit.gestorinscripciones.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne // Cambiamos a ManyToOne si un equipo puede estar asociado a un solo curso
    @JoinColumn(name = "curso_id") // Nombre de la columna en la tabla Equipo
    private Curso curso; //
    @OneToMany(mappedBy = "equipo")
    @JsonManagedReference  //Esta anotación se coloca en el lado “padre” de la relación.
                            // Indica que esta parte de la relación debe ser serializada.
    private List<User> usuarios;


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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }



    public List<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }



}
