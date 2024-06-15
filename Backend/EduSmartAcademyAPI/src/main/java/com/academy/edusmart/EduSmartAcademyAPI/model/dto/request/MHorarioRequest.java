package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MHorarioRequest {
    @NotBlank(message = "El campo dia no puede estar vacio")
    private String dia;

    @NotNull(message = "El campo gestion no puede ser nulo")
    private Integer gestion;

    public MHorarioRequest() {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }
}
