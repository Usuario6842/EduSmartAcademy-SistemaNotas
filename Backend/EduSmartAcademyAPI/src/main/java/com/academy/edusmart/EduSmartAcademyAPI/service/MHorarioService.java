package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MHorarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MHorarioResponse;

import java.util.List;

public interface MHorarioService {
    public List<MHorarioResponse> findAll();
    public MHorarioResponse findById(Long id);
    public MHorarioResponse create(MHorarioRequest mHorarioRequest);
    public MHorarioResponse update(Long id, MHorarioRequest mHorarioRequest);
    public void delete(Long id);

}
