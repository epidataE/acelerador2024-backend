package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Empresa;
import com.poloit.gestorinscripciones.model.Estudiante;
import com.poloit.gestorinscripciones.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @PostMapping()
    public void crearEmpresa(@RequestBody Empresa empresa){
        empresaService.crearEmpresa(empresa);
    }
    @GetMapping()
    public List<Empresa> mostrarEmpresas(){
        return empresaService.mostrarEmpresas();
    }
    @GetMapping("/{id}")
    public Optional<Empresa> empresaId(@PathVariable Long id){
        return empresaService.empresaId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable Long id){
        empresaService.eliminarEmpresa(id);
    }
    @PutMapping("/{id}")
    public Empresa actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa){
        return empresaService.actualizarEmpresa(id, empresa);
    }


}
