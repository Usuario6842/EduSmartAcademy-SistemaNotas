package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MateriaRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MateriaResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.MateriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {
    public final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public ResponseEntity<List<MateriaResponse>> findAll(){
        List<MateriaResponse>   materiaResponses = materiaService.findAll();
        return ResponseEntity.ok(materiaResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponse> findById(@PathVariable Long id){
        MateriaResponse materiaResponse = materiaService.findById(id);
        return ResponseEntity.ok(materiaResponse);
    }

    @PostMapping
    public ResponseEntity<MateriaResponse> create(@Valid @RequestBody MateriaRequest materiaRequest){
        MateriaResponse materiaResponse = materiaService.create(materiaRequest);
        URI location = URI.create("api/materias/"+materiaResponse.getId());
        return ResponseEntity.created(location).body(materiaResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaResponse> update(@PathVariable Long id, @Valid @RequestBody MateriaRequest materiaRequest){
        MateriaResponse materiaResponse = materiaService.update(id, materiaRequest);
        return ResponseEntity.ok(materiaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        materiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
