package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.AulaRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.AulaResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.AulaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    public final AulaService aulaService;

    public AulaController(AulaService aulaService){
        this.aulaService = aulaService;
    }

    @GetMapping
    public ResponseEntity<List<AulaResponse>> findAll(){
        List<AulaResponse> aulaResponses = aulaService.findAll();
        return ResponseEntity.ok(aulaResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AulaResponse> findById(@PathVariable Long id){
        AulaResponse aulaResponse = aulaService.findById(id);
        return ResponseEntity.ok(aulaResponse);
    }

    @PostMapping()
    public ResponseEntity<AulaResponse> create(@Valid @RequestBody AulaRequest aulaRequest){
        AulaResponse aulaResponse = aulaService.create(aulaRequest);
        URI location = URI.create("api/aulas/"+aulaResponse.getId());
        return ResponseEntity.created(location).body(aulaResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaResponse> update(@PathVariable Long id,@Valid @RequestBody AulaRequest aulaRequest){
        AulaResponse aulaResponse = aulaService.update(id, aulaRequest);
        return ResponseEntity.ok(aulaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        aulaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}