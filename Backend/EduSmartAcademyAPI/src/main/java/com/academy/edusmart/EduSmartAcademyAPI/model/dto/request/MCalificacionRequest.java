package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class MCalificacionRequest {
    @NotNull(message = "El campo id_materia no puede ser nulo")
    private Long id_materia;

    @NotNull(message = "El campo id_estudiante no puede ser nulo")
    private Long id_estudiante;

    @NotNull(message = "El campo id_docente no puede ser nulo")
    private Long id_docente;

    public MCalificacionRequest() {
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
