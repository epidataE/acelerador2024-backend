package com.poloit.gestorinscripciones.repository;

import com.poloit.gestorinscripciones.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
