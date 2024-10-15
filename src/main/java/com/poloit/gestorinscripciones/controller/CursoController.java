package com.poloit.gestorinscripciones.controller;

import com.poloit.gestorinscripciones.exceptions.ResourceNotFoundException;
import com.poloit.gestorinscripciones.model.Curso;
import com.poloit.gestorinscripciones.model.CursoDTO;
import com.poloit.gestorinscripciones.model.User;
import com.poloit.gestorinscripciones.service.CursoService;
import com.poloit.gestorinscripciones.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.crearCurso(curso);
        return ResponseEntity.ok(nuevoCurso);
    }

    @PostMapping("/{cursoId}/inscripcion")
    public ResponseEntity<User> inscribirUsuario(@PathVariable Long cursoId, @RequestBody Long usuarioId) {
        Curso curso = cursoService.cursoId(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        User usuario = userService.userId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar si el usuario ya está inscrito en un curso
        if (usuario.getCurso() != null && usuario.getCurso().isEstado()) {
            throw new RuntimeException("El usuario ya está inscrito en un curso.");
        }

        usuario.setCurso(curso);
        userService.actualizarUser(usuarioId, usuario);

        return ResponseEntity.ok(usuario);
    }

    @GetMapping()
    public ResponseEntity<List<CursoDTO>> listarCursosConUsuarios() {
        List<CursoDTO> cursos = cursoService.obtenerCursosConUsuarios();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Curso>> obtenerCursosActivos() {
        List<Curso> cursosActivos = cursoService.obtenerCursosActivos(); // Método que debes implementar
        return ResponseEntity.ok(cursosActivos);
    }

    @GetMapping("/{id}")
    public Optional<Curso> cursoId(@PathVariable Long id){
        return cursoService.cursoId(id);
    }

    @PutMapping("/{id}")
        public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso){
            return cursoService.actualizarCurso(id, curso);
        }


    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
    }




}
