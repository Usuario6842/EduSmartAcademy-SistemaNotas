package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotNull;

public class DCalificacionRequest {

    @NotNull(message = "el campo ser no puede ser nulo")
    private Double ser;

    @NotNull(message = "el campo saber no puede ser nulo")
    private Double saber;

    @NotNull(message = "el campo hacer no puede ser nulo")
    private Double hacer;

    @NotNull(message = "el campo decidir no puede ser nulo")
    private Double decidir;

    @NotNull(message = "el campo de autoevaluacion no puede ser nulo")
    private Double autoevaluacion;

    @NotNull(message = "el campo de notafinal no puede ser nulo")
    private Double notafinal;

    @NotNull(message = "el campo de id_calificacion no puede ser nulo")
    private Long id_calificacion;

    public DCalificacionRequest() {
    }

    public Double getSer() {
        return ser;
    }

    public void setSer(Double ser) {
        this.ser = ser;
    }

    public Double getSaber() {
        return saber;
    }

    public void setSaber(Double saber) {
        this.saber = saber;
    }

    public Double getHacer() {
        return hacer;
    }

    public void setHacer(Double hacer) {
        this.hacer = hacer;
    }

    public Double getDecidir() {
        return decidir;
    }

    public void setDecidir(Double decidir) {
        this.decidir = decidir;
    }

    public Double getAutoevaluacion() {
        return autoevaluacion;
    }

    public void setAutoevaluacion(Double autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }

    public Double getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(Double notafinal) {
        this.notafinal = notafinal;
    }

    public Long getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Long id_calificacion) {
        this.id_calificacion = id_calificacion;
    }
}
