package com.poloit.gestorinscripciones.model;

public class MensajeDTO {
    private Long remitenteId;
    private Long destinatarioId;
    private String contenido;

    // Constructor
    public MensajeDTO() {}

    public MensajeDTO(Long remitenteId, Long destinatarioId, String contenido) {
        this.remitenteId = remitenteId;
        this.destinatarioId = destinatarioId;
        this.contenido = contenido;
    }

    // Getters y Setters
    public Long getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(Long remitenteId) {
        this.remitenteId = remitenteId;
    }

    public Long getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
