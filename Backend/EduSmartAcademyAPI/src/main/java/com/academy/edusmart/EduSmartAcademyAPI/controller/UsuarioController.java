package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.UsuarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.UsuarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll(){
        List<UsuarioResponse> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id){
        UsuarioResponse usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<List<UsuarioResponse>> findAllByRol(@PathVariable Long id){
        List<UsuarioResponse> usuarios = usuarioService.findAllByRol(id);
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> create(@Valid @RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse usuario = usuarioService.create(usuarioRequest);
        URI location = URI.create("/api/usuarios/"+usuario.getId());
        return ResponseEntity.created(location).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id,@Valid @RequestBody UsuarioRequest usuarioRequest){
        UsuarioResponse usuario = usuarioService.update(id, usuarioRequest);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
