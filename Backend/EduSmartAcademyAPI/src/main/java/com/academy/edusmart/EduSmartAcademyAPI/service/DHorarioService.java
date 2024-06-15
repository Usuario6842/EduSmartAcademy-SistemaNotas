package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DHorarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DHorarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Aula;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Docente;

import java.util.List;

public interface DHorarioService {
    public List<DHorarioResponse> findAll();
    public DHorarioResponse findById(Long id);
    public List<DHorarioResponse> findAllByDocente(Long idDocente);
    public List<DHorarioResponse> findAllByAula(Long idAula);
    public DHorarioResponse create(DHorarioRequest dHorarioRequest);
    public DHorarioResponse update(Long id, DHorarioRequest dHorarioRequest);
    public void delete(Long id);

}
