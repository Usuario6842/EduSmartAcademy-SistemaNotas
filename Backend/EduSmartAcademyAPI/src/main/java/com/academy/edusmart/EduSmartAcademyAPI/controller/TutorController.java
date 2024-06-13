package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.TutorRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.TutorResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/tutor")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService){
        this.tutorService = tutorService;
    }

    @GetMapping
    ResponseEntity<List<TutorResponse>> findAll(){
        List<TutorResponse> tutorResponses = tutorService.findAll();
        return ResponseEntity.ok(tutorResponses);
    }

    @GetMapping("/{id}")
    ResponseEntity<TutorResponse> findById(@PathVariable Long id){
        TutorResponse tutorResponse = tutorService.findById(id);
        return ResponseEntity.ok(tutorResponse);
    }

    @GetMapping("/estudiante/{id}")
    ResponseEntity<List<TutorResponse>> findAllByEstudiante(@PathVariable Long id){
        List<TutorResponse> tutorResponses = tutorService.findAllByEstudiante(id);
        return ResponseEntity.ok(tutorResponses);
    }

    @PostMapping
    ResponseEntity<TutorResponse> save(@Valid @RequestBody TutorRequest tutorRequest){
        TutorResponse tutorResponse = tutorService.create(tutorRequest);
        URI location = URI.create("api/tutor/"+tutorResponse.getId());
        return ResponseEntity.created(location).body(tutorResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<TutorResponse> update(@PathVariable Long id, @Valid @RequestBody TutorRequest tutorRequest){
        TutorResponse tutorResponse = tutorService.update(id, tutorRequest);
        return ResponseEntity.ok(tutorResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        tutorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
