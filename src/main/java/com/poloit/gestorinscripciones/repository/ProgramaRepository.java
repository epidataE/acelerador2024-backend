package com.poloit.gestorinscripciones.repository;

import com.poloit.gestorinscripciones.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {
}