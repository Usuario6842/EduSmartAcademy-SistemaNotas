package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DHorarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MHorarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DHorarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MHorarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.DHorarioService;
import com.academy.edusmart.EduSmartAcademyAPI.service.MHorarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/horario")
public class HorarioController {
    private final MHorarioService mHorarioService;
    private final DHorarioService dHorarioService;

    public HorarioController(MHorarioService mHorarioService, DHorarioService dHorarioService) {
        this.mHorarioService = mHorarioService;
        this.dHorarioService = dHorarioService;
    }

    @GetMapping
    public ResponseEntity<List<MHorarioResponse>> findAll(){
        List<MHorarioResponse> mHorarioResponses = mHorarioService.findAll();
        return ResponseEntity.ok(mHorarioResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MHorarioResponse> findById(@PathVariable Long id){
        MHorarioResponse mHorarioResponse = mHorarioService.findById(id);
        return ResponseEntity.ok(mHorarioResponse);
    }

    @PostMapping()
    public ResponseEntity<MHorarioResponse> create(@Valid @RequestBody MHorarioRequest mHorarioRequest){
        MHorarioResponse mHorarioResponse = mHorarioService.create(mHorarioRequest);
        URI location = URI.create("/api/horario/"+mHorarioResponse.getId());
        return ResponseEntity.created(location).body(mHorarioResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MHorarioResponse> update(@PathVariable Long id, @Valid @RequestBody MHorarioRequest mHorarioRequest){
        MHorarioResponse mHorarioResponse = mHorarioService.update(id, mHorarioRequest);
        return ResponseEntity.ok(mHorarioResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        mHorarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalle")
    public ResponseEntity<List<DHorarioResponse>> findAllDetalle(){
        List<DHorarioResponse> dHorarioResponses = dHorarioService.findAll();
        return ResponseEntity.ok(dHorarioResponses);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<DHorarioResponse> findByIdDetalle(@PathVariable Long id){
        DHorarioResponse dHorarioResponse = dHorarioService.findById(id);
        return ResponseEntity.ok(dHorarioResponse);
    }

    @GetMapping("/detalle/aula/{id}")
    public ResponseEntity<List<DHorarioResponse>> findAllByAulaDetalle(@PathVariable Long id){
        List<DHorarioResponse> dHorarioResponses = dHorarioService.findAllByAula(id);
        return ResponseEntity.ok(dHorarioResponses);
    }

    @GetMapping("/detalle/docente/{id}")
    public ResponseEntity<List<DHorarioResponse>> findAllByDocenteDetalle(@PathVariable Long id){
        List<DHorarioResponse> dHorarioResponses = dHorarioService.findAllByDocente(id);
        return ResponseEntity.ok(dHorarioResponses);
    }

    @PostMapping("/detalle")
    public ResponseEntity<DHorarioResponse> createDetalle(@Valid @RequestBody DHorarioRequest dHorarioRequest){
        DHorarioResponse dHorarioResponse = dHorarioService.create(dHorarioRequest);
        URI location = URI.create("/api/horario/detalle/"+dHorarioResponse.getId());
        return ResponseEntity.created(location).body(dHorarioResponse);
    }

    @PutMapping("/detalle/{id}")
    public ResponseEntity<DHorarioResponse> updateDetalle(@PathVariable Long id, @Valid @RequestBody DHorarioRequest dHorarioRequest){
        DHorarioResponse dHorarioResponse = dHorarioService.update(id, dHorarioRequest);
        return ResponseEntity.ok(dHorarioResponse);
    }

    @DeleteMapping("/detalle/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Long id){
        dHorarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
