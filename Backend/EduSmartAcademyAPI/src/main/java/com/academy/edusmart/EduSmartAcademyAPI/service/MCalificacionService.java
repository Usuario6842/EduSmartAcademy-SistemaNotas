package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MCalificacionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MCalificacionResponse;

import java.util.List;

public interface MCalificacionService {
    public List<MCalificacionResponse> findAll();
    public MCalificacionResponse findById(Long id);
    public List<MCalificacionResponse> findAllByMateria(Long idMat);
    public List<MCalificacionResponse> findAllByEstudiante(Long idEst);
    public MCalificacionResponse create(MCalificacionRequest mCalificacionRequest);
    public MCalificacionResponse update(Long id, MCalificacionRequest mCalificacionRequest);
    public void delete(Long id);
}
