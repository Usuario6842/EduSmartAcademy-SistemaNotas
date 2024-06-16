package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleDocente;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleEstudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleMateria;

public class DCalificacionResponse {
    private Long id;
    private Double ser;
    private Double saber;
    private Double hacer;
    private Double decidir;
    private Double autoevaluacion;
    private Double notaFinal;
    private MCalificacionResponse detalle;

    public DCalificacionResponse(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public MCalificacionResponse getDetalle() {
        return detalle;
    }

    public void setDetalle(MCalificacionResponse calificacion) {
        this.detalle = calificacion;
    }
}
