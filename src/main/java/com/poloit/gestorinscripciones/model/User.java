package com.poloit.gestorinscripciones.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String apellido;
    private String nombre;
    private String email;
    private String contrasena;
    private String fecha_creacion;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
    //en el caso de ser Estudiante --> relaciona con un Curso
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = true)
    private Curso curso;
    //en caso de ser Mentor --> relaciona con Empresa Socia
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = true)
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // Constructor por defecto
    public User() {
    }

    public User(String apellido, String nombre, String email, String contrasena, String fecha_creacion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.fecha_creacion = fecha_creacion;
    }
    //Getters/Setters

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
