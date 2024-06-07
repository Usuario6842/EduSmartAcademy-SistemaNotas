package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MateriaRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MateriaResponse;

import java.util.List;

public interface MateriaService {
    public List<MateriaResponse> findAll();
    public MateriaResponse findById(long id);
    public MateriaResponse create(MateriaRequest materiaRequest);
    public MateriaResponse update(Long id, MateriaRequest materiaRequest);
    public void delete(long id);
}
