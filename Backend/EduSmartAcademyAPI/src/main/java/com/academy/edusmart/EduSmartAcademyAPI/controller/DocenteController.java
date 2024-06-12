package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DocenteRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DocenteResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.DocenteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/docente")
public class DocenteController {

    private DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public ResponseEntity<List<DocenteResponse>> findAll(){
        List<DocenteResponse> docenteResponses = docenteService.findAll();
        return ResponseEntity.ok(docenteResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteResponse> findById(@PathVariable Long id){
        DocenteResponse docenteResponse = docenteService.findById(id);
        return ResponseEntity.ok(docenteResponse);
    }

    @PostMapping()
    public ResponseEntity<DocenteResponse> create(@Valid @RequestBody DocenteRequest docenteRequest){
        DocenteResponse docenteResponse = docenteService.create(docenteRequest);
        URI location = URI.create("api/docente/" +docenteResponse.getId());

        return ResponseEntity.created(location).body(docenteResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteResponse> update(@PathVariable Long id, @Valid @RequestBody DocenteRequest docenteRequest){
        DocenteResponse docenteResponse = docenteService.update(id, docenteRequest);
        return ResponseEntity.ok(docenteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        docenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
