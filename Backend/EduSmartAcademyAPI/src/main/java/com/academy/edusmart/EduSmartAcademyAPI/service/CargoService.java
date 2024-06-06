package com.academy.edusmart.EduSmartAcademyAPI.service;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.CargoRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.CargoResponse;

import java.util.List;

public interface CargoService {
    public List<CargoResponse> findAll();
    public CargoResponse findById(Long id);
    public CargoResponse create(CargoRequest cargoRequest);
    public CargoResponse update(Long id, CargoRequest cargoRequest);
    public void delete(Long id);
}
