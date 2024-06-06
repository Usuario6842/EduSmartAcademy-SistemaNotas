package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.RolRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.RolResponse;

import java.util.List;

public interface RolService {
    public List<RolResponse> findAll();
    public RolResponse findById(long id);
    public RolResponse create(RolRequest rolRequest);
    public RolResponse update(Long id, RolRequest rolRequest);
    public void delete(long id);
}
