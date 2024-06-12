package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.PersonalRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.PersonalResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.PersonalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/personal")
public class PersonalController {

    private final PersonalService personalService;

    PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping
    public ResponseEntity<List<PersonalResponse>> findAll(){
        List<PersonalResponse> personalResponses = personalService.findAll();
        return ResponseEntity.ok(personalResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalResponse> findById(@PathVariable Long id){
        PersonalResponse personsResponse = personalService.findById(id);
        return ResponseEntity.ok(personsResponse);
    }

    @GetMapping("/cargo/{id}")
    public ResponseEntity<List<PersonalResponse>> findAllByCargo(@PathVariable Long id){
        List<PersonalResponse> personalResponses = personalService.findAllByCargo(id);
        return ResponseEntity.ok(personalResponses);
    }

    @PostMapping
    public ResponseEntity<PersonalResponse> create(@Valid @RequestBody PersonalRequest personalRequest){
        PersonalResponse personalResponse = personalService.create(personalRequest);
        URI location = URI.create("api/personal"+personalResponse.getId());
        return ResponseEntity.created(location).body(personalResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalResponse> update(@PathVariable Long id, @Valid @RequestBody PersonalRequest personalRequest){
        PersonalResponse personalResponse = personalService.update(id, personalRequest);
        return ResponseEntity.ok(personalResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
