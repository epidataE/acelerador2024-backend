package com.poloit.gestorinscripciones.repository;

import com.poloit.gestorinscripciones.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
