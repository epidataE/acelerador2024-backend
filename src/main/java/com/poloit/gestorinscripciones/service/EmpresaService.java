package com.poloit.gestorinscripciones.service;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Empresa;
import com.poloit.gestorinscripciones.model.TipoEntidad;
import com.poloit.gestorinscripciones.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

   public void crearEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
   }

   public List<Empresa> mostrarEmpresas(){
        return empresaRepository.findAll();
    }
    public Optional<Empresa> empresaId(Long id) throws ResourceNotFoundException {
        if (empresaRepository.findById(id).isPresent()){
            return empresaRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Empresa", "id", id);
        }
    }
    public List<Empresa> obtenerEmpresasPorTipoEntidad(TipoEntidad tipoEntidad) {
        return empresaRepository.findByTipoEntidad(tipoEntidad);
    }
    public void eliminarEmpresa(Long id){
        if (empresaRepository.findById(id).isPresent()) {
            empresaRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("not found", "Empresa", "id", id);
        }
    }
    public Empresa actualizarEmpresa(Long id, Empresa empresa) throws ResourceNotFoundException {
        Optional<Empresa> empresaAModificar = empresaRepository.findById(id);
        if (empresaAModificar.isPresent()) {
            Empresa empresaModificado = empresaAModificar.get();
            empresaModificado.setNombre(empresa.getNombre());
            empresaModificado.setDescripcion(empresa.getDescripcion());
            empresaModificado.setContacto(empresa.getContacto());
            empresaModificado.setTipoEntidad(empresa.getTipoEntidad());
            return empresaRepository.save(empresaModificado);

        } else {
            throw new ResourceNotFoundException("not found", "Empresa", "id", id);
        }
    }

}
