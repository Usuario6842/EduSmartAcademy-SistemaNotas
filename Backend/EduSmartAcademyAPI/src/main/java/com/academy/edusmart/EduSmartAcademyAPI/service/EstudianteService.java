package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.EstudianteRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.EstudianteResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Estudiante;

import java.util.List;

public interface EstudianteService {
    public List<EstudianteResponse> findAll();
    public EstudianteResponse findById(Long id);
    public EstudianteResponse create(EstudianteRequest estudianteRequest);
    public EstudianteResponse update(Long id, EstudianteRequest estudianteRequest);
    public void delete(Long id);

}
