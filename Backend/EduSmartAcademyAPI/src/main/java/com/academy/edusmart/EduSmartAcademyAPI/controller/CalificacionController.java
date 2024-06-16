package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DCalificacionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MCalificacionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DCalificacionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MCalificacionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.DCalificacionService;
import com.academy.edusmart.EduSmartAcademyAPI.service.MCalificacionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/notas")
public class CalificacionController {

    private final MCalificacionService mCalificacionService;
    private final DCalificacionService dCalificacionService;

    public CalificacionController(MCalificacionService mCalificacionService, DCalificacionService dCalificacionService) {
        this.mCalificacionService = mCalificacionService;
        this.dCalificacionService = dCalificacionService;
    }

    @GetMapping
    public ResponseEntity<List<MCalificacionResponse>> findAll(){
        List<MCalificacionResponse> mCalificacionResponses = mCalificacionService.findAll();
        return ResponseEntity.ok(mCalificacionResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MCalificacionResponse> findById(@PathVariable Long id){
        MCalificacionResponse mCalificacionResponse = mCalificacionService.findById(id);
        return ResponseEntity.ok(mCalificacionResponse);
    }

    @GetMapping("/materia/{id}")
    public ResponseEntity<List<MCalificacionResponse>> findAllByMateria(@PathVariable Long id){
        List<MCalificacionResponse> mCalificacionResponses = mCalificacionService.findAllByMateria(id);
        return ResponseEntity.ok(mCalificacionResponses);
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<MCalificacionResponse>> findAllByEstudiante(@PathVariable Long id){
        List<MCalificacionResponse> mCalificacionResponses = mCalificacionService.findAllByEstudiante(id);
        return ResponseEntity.ok(mCalificacionResponses);
    }

    @PostMapping
    public ResponseEntity<MCalificacionResponse> save(@Valid @RequestBody MCalificacionRequest mCalificacionRequest){
        MCalificacionResponse mCalificacion = mCalificacionService.create(mCalificacionRequest);
        URI location = URI.create("api/notas/"+mCalificacion.getId());
        return ResponseEntity.created(location).body(mCalificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MCalificacionResponse> update(@PathVariable Long id, @Valid @RequestBody MCalificacionRequest mCalificacionRequest){
        MCalificacionResponse mCalificacionResponse = mCalificacionService.update(id, mCalificacionRequest);
        return ResponseEntity.ok(mCalificacionResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        mCalificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalle")
    public ResponseEntity<List<DCalificacionResponse>> findAllDetalle(){
        List<DCalificacionResponse> dCalificacionResponses = dCalificacionService.findAll();
        return ResponseEntity.ok(dCalificacionResponses);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<DCalificacionResponse> findByIdDetalle(@PathVariable Long id){
        DCalificacionResponse dCalificacionResponse = dCalificacionService.findById(id);
        return ResponseEntity.ok(dCalificacionResponse);
    }

    @GetMapping("/detalle/registro/{id}")
    public ResponseEntity<List<DCalificacionResponse>> findAllByCalificacion(@PathVariable Long id){
        List<DCalificacionResponse> dCalificacionResponses = dCalificacionService.findAllByCalificacion(id);
        return ResponseEntity.ok(dCalificacionResponses);
    }

    @PostMapping("/detalle")
    public ResponseEntity<DCalificacionResponse> createDetalle(@Valid @RequestBody DCalificacionRequest dCalificacionRequest){
        DCalificacionResponse dCalificacion = dCalificacionService.create(dCalificacionRequest);
        URI location = URI.create("api/notas/detalle/"+dCalificacion.getId());
        return ResponseEntity.created(location).body(dCalificacion);
    }

    @PutMapping("/detalle/{id}")
    public ResponseEntity<DCalificacionResponse> updateDetalle(@PathVariable Long id, @Valid @RequestBody DCalificacionRequest dCalificacionRequest){
        DCalificacionResponse dCalificacionResponse = dCalificacionService.update(id, dCalificacionRequest);
        return ResponseEntity.ok(dCalificacionResponse);
    }

    @DeleteMapping("/detalle/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Long id){
        dCalificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
