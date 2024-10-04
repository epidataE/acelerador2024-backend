package com.poloit.gestorinscripciones.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @Enumerated(EnumType.STRING) //EnumType.STRING almacena el nombre de enum como texto
    private Rol rol;

    @Enumerated(EnumType.STRING)
    private Especializacion especializacion;

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
    @JsonBackReference //Esta anotación se coloca en el lado “hijo” de la relación.
                       // Indica que esta parte de la relación no debe ser serializada, evitando así la recursión infinita.
    private Equipo equipo;
    // Relación para mensajes enviados
    @OneToMany(mappedBy = "remitente")
    @JsonManagedReference // Esta anotación se coloca en el lado “padre” de la relación.
    // Indica que esta parte de la relación debe ser serializada.
    private Set<Mensaje> mensajesEnviados;

    // Relación para mensajes recibidos
    @OneToMany(mappedBy = "destinatario")
    @JsonManagedReference // Esta anotación se coloca en el lado “padre” de la relación.
    // Indica que esta parte de la relación debe ser serializada.
    private Set<Mensaje> mensajesRecibidos;


    // Constructor por defecto
    public User() {
    }

    public User(String apellido, String nombre, String email, String contrasena, String fecha_creacion,
                Rol rol, Especializacion especializacion, Empresa empresa) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.fecha_creacion = fecha_creacion;
        this.rol = rol;
        this.especializacion= especializacion;
        this.empresa = empresa;
        // Inicializar las colecciones para evitar NullPointerException
        this.mensajesEnviados = new HashSet<>();
        this.mensajesRecibidos = new HashSet<>();
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

    public Especializacion getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especializacion especializacion) {
        this.especializacion = especializacion;
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
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Set<Mensaje> getMensajesEnviados() {
        return mensajesEnviados;
    }

    public void setMensajesEnviados(Set<Mensaje> mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public Set<Mensaje> getMensajesRecibidos() {
        return mensajesRecibidos;
    }

    public void setMensajesRecibidos(Set<Mensaje> mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }
}

