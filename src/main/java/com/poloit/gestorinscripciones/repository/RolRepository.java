package com.poloit.gestorinscripciones.repository;

import com.poloit.gestorinscripciones.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
