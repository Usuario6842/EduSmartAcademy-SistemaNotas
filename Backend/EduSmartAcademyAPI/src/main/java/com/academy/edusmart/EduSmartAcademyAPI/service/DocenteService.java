package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DocenteRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DocenteResponse;

import java.util.List;

public interface DocenteService {
    public List<DocenteResponse> findAll();
    public DocenteResponse findById(Long id);
    public DocenteResponse create(DocenteRequest docenteRequest);
    public DocenteResponse update(Long id, DocenteRequest docenteRequest);
    public void delete(Long id);
}
