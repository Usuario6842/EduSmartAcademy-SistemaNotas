package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.TutorRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.TutorResponse;

import java.util.List;

public interface TutorService {
    public List<TutorResponse> findAll();
    public TutorResponse findById(Long id);
    public List<TutorResponse> findAllByEstudiante(Long idEstudiante);
    public TutorResponse create(TutorRequest tutorRequest);
    public TutorResponse update(Long id, TutorRequest tutorRequest);
    public void delete(Long id);
}
