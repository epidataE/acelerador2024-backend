package com.poloit.gestorinscripciones.repository;

import com.poloit.gestorinscripciones.model.Empresa;
import com.poloit.gestorinscripciones.model.TipoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findByTipoEntidad(TipoEntidad tipoEntidad);
}
