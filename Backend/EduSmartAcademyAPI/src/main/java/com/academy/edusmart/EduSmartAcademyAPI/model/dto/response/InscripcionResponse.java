package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleAula;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleDocente;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleEstudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleMateria;

import java.time.LocalDate;

public class InscripcionResponse {
    private Long id;
    private SimpleAula aula;
    private SimpleMateria materia;
    private SimpleEstudiante estudiante;
    private SimpleDocente docente;
    private LocalDate fInscripcion;
    private LocalDate fInicio;
    private LocalDate fFinal;

    public InscripcionResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getfInscripcion() {
        return fInscripcion;
    }

    public void setfInscripcion(LocalDate fInscripcion) {
        this.fInscripcion = fInscripcion;
    }

    public LocalDate getfInicio() {
        return fInicio;
    }

    public void setfInicio(LocalDate fInicio) {
        this.fInicio = fInicio;
    }

    public LocalDate getfFinal() {
        return fFinal;
    }

    public void setfFinal(LocalDate fFinal) {
        this.fFinal = fFinal;
    }

    public SimpleAula getAula() {
        return aula;
    }

    public void setAula(SimpleAula aula) {
        this.aula = aula;
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
