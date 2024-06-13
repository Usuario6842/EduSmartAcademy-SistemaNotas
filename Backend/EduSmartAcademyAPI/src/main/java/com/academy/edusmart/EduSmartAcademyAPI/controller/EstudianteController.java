package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.EstudianteRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.EstudianteResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("api/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    EstudianteController(EstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteResponse>> findAll(){
        List<EstudianteResponse> estudianteResponses = estudianteService.findAll();
        return ResponseEntity.ok(estudianteResponses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponse> findById(@PathVariable Long id){
        EstudianteResponse estudianteResponse = estudianteService.findById(id);
        return ResponseEntity.ok(estudianteResponse);
    }
    @PostMapping
    public ResponseEntity<EstudianteResponse> create(@Valid @RequestBody EstudianteRequest estudianteRequest){
        EstudianteResponse estudianteResponse = estudianteService.create(estudianteRequest);
        URI location = URI.create("api/estudiante/"+estudianteResponse.getId());
        return ResponseEntity.created(location).body(estudianteResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponse> update(@PathVariable Long id, @Valid @RequestBody EstudianteRequest estudianteRequest){
        EstudianteResponse estudianteResponse = estudianteService.update(id, estudianteRequest);
        return ResponseEntity.ok(estudianteResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        estudianteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
