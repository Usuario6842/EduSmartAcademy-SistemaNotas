package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.RolRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.RolResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.RolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    public final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolResponse>> findAll(){
        List<RolResponse>   rolResponses = rolService.findAll();
        return ResponseEntity.ok(rolResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponse> findById(@PathVariable Long id){
        RolResponse rolResponse = rolService.findById(id);
        return ResponseEntity.ok(rolResponse);
    }

    @PostMapping
    public ResponseEntity<RolResponse> create(@Valid @RequestBody RolRequest rolRequest){
        RolResponse rolResponse = rolService.create(rolRequest);
        URI location = URI.create("api/roles/"+rolResponse.getId());
        return ResponseEntity.created(location).body(rolResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolResponse> update(@PathVariable Long id, @Valid @RequestBody RolRequest rolRequest){
        RolResponse rolResponse = rolService.update(id, rolRequest);
        return ResponseEntity.ok(rolResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
