package com.poloit.gestorinscripciones.model;
import jakarta.persistence.*;


@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nombre;
    private String descripcion;
    private String fecha_inicio;
    private String  fecha_fin;
    //private Long programa_id;
    @ManyToOne
    @JoinColumn(name = "programa_id")
    private Programa programa;

    // Constructor por defecto
    public Curso() {
    }

   public Curso(String nombre, String descripcion, String fecha_inicio, String fecha_fin){
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.fecha_inicio=fecha_inicio;
       this.fecha_fin = fecha_fin;
       //this.programa_id = programa_id;

   }

   //getters-setters
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

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }


}
