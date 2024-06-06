package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.AulaRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.AulaResponse;

import java.util.List;

public interface AulaService {
    public List<AulaResponse> findAll();
    public AulaResponse findById(Long id);
    public AulaResponse create(AulaRequest aulaRequest);
    public AulaResponse update(Long id, AulaRequest aulaRequest);
    public void delete(Long id);

}
