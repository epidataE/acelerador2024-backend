package com.poloit.gestorinscripciones.repository;

import com.poloit.gestorinscripciones.model.Especializacion;
import com.poloit.gestorinscripciones.model.Rol;
import com.poloit.gestorinscripciones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRol(Rol rol);
    List<User> findByEspecializacion(Especializacion especializacion);
}
