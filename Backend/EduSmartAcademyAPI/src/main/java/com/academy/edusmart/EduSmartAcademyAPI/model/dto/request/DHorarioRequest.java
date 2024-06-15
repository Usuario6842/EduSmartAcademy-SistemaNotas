package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class DHorarioRequest {

    @NotNull(message = "El campo periodo no puede ser nulo")
    private Integer periodo;

    @NotNull(message = "El campo id_mhorario no puede ser nulo")
    private Long id_mh;

    @NotNull(message = "El campo id_aula no puede ser nulo")
    private Long id_aula;

    @NotNull(message = "El campo id_materia no puede ser nulo")
    private Long id_materia;

    @NotNull(message = "El campo id_docente no puede ser nulo")
    private Long id_docente;

    public DHorarioRequest() {
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Long getId_mh() {
        return id_mh;
    }

    public void setId_mh(Long id_mh) {
        this.id_mh = id_mh;
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

    public Long getId_docente() {
        return id_docente;
    }

    public void setId_docente(Long id_docente) {
        this.id_docente = id_docente;
    }
}
