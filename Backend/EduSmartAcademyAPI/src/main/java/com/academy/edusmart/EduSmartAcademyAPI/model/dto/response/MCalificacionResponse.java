package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleDocente;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleEstudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleMateria;

public class MCalificacionResponse {
    private Long id;
    private SimpleMateria materia;
    private SimpleEstudiante estudiante;
    private SimpleDocente docente;

    public MCalificacionResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleMateria getMateria() {
        return materia;
    }

    public void setMateria(SimpleMateria materia) {
        this.materia = materia;
    }

    public SimpleEstudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(SimpleEstudiante estudiante) {
        this.estudiante = estudiante;
    }

    public SimpleDocente getDocente() {
        return docente;
    }

    public void setDocente(SimpleDocente docente) {
        this.docente = docente;
    }
}
