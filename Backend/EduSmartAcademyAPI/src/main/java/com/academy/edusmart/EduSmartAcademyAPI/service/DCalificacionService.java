package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DCalificacionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DCalificacionResponse;

import java.util.List;

public interface DCalificacionService {
    public List<DCalificacionResponse> findAll();
    public DCalificacionResponse findById(Long id);
    public List<DCalificacionResponse> findAllByCalificacion(Long idCal);
    public DCalificacionResponse create(DCalificacionRequest dCalificacionRequest);
    public DCalificacionResponse update(Long id, DCalificacionRequest dCalificacionRequest);
    public void delete(Long id);
}
