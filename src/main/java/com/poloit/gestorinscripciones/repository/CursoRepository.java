package com.poloit.gestorinscripciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.poloit.gestorinscripciones.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
