package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

import java.util.List;

public class MHorarioResponse {
    private Long id;
    private String dia;
    private Integer gestion;

    public MHorarioResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

}
