package com.poloit.gestorinscripciones.repository;

import com.poloit.gestorinscripciones.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
