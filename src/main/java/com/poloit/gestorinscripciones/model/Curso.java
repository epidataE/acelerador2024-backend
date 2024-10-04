package com.poloit.gestorinscripciones.model;
import jakarta.persistence.*;


@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nombre;
    private String descripcion;
    private String rubro;
    @Column(nullable = true) // Indica que este campo puede ser nulo
    private String institucion;

    // Constructor por defecto
    public Curso() {
    }

   public Curso(String nombre, String descripcion, String rubro, String institucion){
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.rubro=rubro;
       this.institucion = institucion;


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

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
}
