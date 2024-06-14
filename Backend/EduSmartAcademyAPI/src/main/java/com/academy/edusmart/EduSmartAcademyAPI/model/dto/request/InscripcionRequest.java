package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class InscripcionRequest {

    @NotNull(message = "El campo fecha de inscripcion no puede ser nulo")
    private LocalDate fInscripcion;

    @NotNull(message = "El campo fecha de inicio no puede ser nulo")
    private LocalDate fInicio;

    @NotNull(message = "El campo fecha final no puede ser nulo")
    private LocalDate fFinal;

    @NotNull(message = "El campo id_aula no puede ser nulo")
    private Long id_aula;

    @NotNull(message = "El campo id_materia no puede ser nulo")
    private Long id_materia;

    @NotNull(message = "El campo id_estudiante no puede ser nulo")
    private Long id_estudiante;

    @NotNull(message = "El campo id_docente no puede ser nulo")
    private Long id_docente;

    public InscripcionRequest() {
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

    public Long getId_aula() {
        return id_aula;
    }

    public void setId_aula(Long id_aula) {
        this.id_aula = id_aula;
    }

    public Long getId_materia() {
        return id_materia;
    }

    public void setId_materia(Long id_materia) {
        this.id_materia = id_materia;
    }

    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Long getId_docente() {
        return id_docente;
    }

    public void setId_docente(Long id_docente) {
        this.id_docente = id_docente;
    }
}
