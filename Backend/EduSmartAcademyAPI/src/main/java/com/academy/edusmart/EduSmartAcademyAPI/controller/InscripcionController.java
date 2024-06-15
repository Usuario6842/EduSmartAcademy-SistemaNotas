package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.InscripcionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.InscripcionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/inscripcion")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @GetMapping
    public ResponseEntity<List<InscripcionResponse>> findAll(){
        List<InscripcionResponse> responses = inscripcionService.findAll();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionResponse> findById(@PathVariable Long id){
        InscripcionResponse response = inscripcionService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/aula/{id}")
    public ResponseEntity<List<InscripcionResponse>> findAllByAula(@PathVariable Long id){
        List<InscripcionResponse> responses = inscripcionService.findAllByAula(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/materia/{id}")
    public ResponseEntity<List<InscripcionResponse>> findAllByMateria(@PathVariable Long id){
        List<InscripcionResponse> responses = inscripcionService.findAllByMateria(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<InscripcionResponse>> findAllByEstudiante(@PathVariable Long id){
        List<InscripcionResponse> responses = inscripcionService.findAllByEstudiante(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/docente/{id}")
    public ResponseEntity<List<InscripcionResponse>> findAllByDocente(@PathVariable Long id){
        List<InscripcionResponse> responses = inscripcionService.findAllByDocente(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/count/materia")
    public ResponseEntity<List<Map<String, Object>>> countInscripcionesByMateria() {
        List<Map<String, Object>> counts =inscripcionService.countInscripcionesByMateria();
        return ResponseEntity.ok(counts);
    }

    @PostMapping
    public ResponseEntity<InscripcionResponse> create(@Valid @RequestBody InscripcionRequest inscripcionRequest){
        InscripcionResponse response = inscripcionService.create(inscripcionRequest);
        URI location = URI.create("api/inscripcion/"+response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionResponse> update(@PathVariable Long id, @Valid @RequestBody InscripcionRequest inscripcionRequest){
        InscripcionResponse response = inscripcionService.update(id, inscripcionRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        inscripcionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
