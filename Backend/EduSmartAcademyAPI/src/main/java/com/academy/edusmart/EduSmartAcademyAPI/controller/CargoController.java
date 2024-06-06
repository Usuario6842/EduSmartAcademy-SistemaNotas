package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.CargoRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.CargoResponse;
import com.academy.edusmart.EduSmartAcademyAPI.service.CargoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class CargoController {

    public final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public ResponseEntity<List<CargoResponse>> findAll() {
        List<CargoResponse> cargoResponses = cargoService.findAll();
        return ResponseEntity.ok(cargoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoResponse> findById(Long id) {
        CargoResponse cargoResponse = cargoService.findById(id);
        return ResponseEntity.ok(cargoResponse);
    }

    @PostMapping
    public ResponseEntity<CargoResponse> create(@Valid @RequestBody CargoRequest cargoRequest) {
        CargoResponse cargoResponse = cargoService.create(cargoRequest);
        URI location = URI.create("/cargo/" + cargoResponse.getId());
        return ResponseEntity.created(location).body(cargoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoResponse> update(@PathVariable Long id, @Valid @RequestBody CargoRequest cargoRequest) {
        CargoResponse cargoResponse = cargoService.update(id, cargoRequest);
        return ResponseEntity.ok(cargoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cargoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
