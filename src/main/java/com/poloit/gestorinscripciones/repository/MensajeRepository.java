package com.poloit.gestorinscripciones.repository;
import com.poloit.gestorinscripciones.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByDestinatario_Id(Long destinatarioId);

    List<Mensaje> findByRemitente_Id(Long remitenteId);
}
