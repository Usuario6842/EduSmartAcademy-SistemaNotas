package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.AulaRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.InscripcionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.InscripcionResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface InscripcionService {
    public List<InscripcionResponse> findAll();
    public InscripcionResponse findById(Long id);
    public List<InscripcionResponse> findAllByAula(Long idAula);
    public List<InscripcionResponse> findAllByMateria(Long idMateria);
    public List<InscripcionResponse> findAllByEstudiante(Long idEstudiante);
    public List<InscripcionResponse> findAllByDocente(Long idDocente);
    public List<Map<String, Object>> countInscripcionesByMateria();

    public InscripcionResponse create(InscripcionRequest inscripcionRequest);
    public InscripcionResponse update(Long id, InscripcionRequest inscripcionRequest);
    public void delete(Long id);
}
