package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DocenteRequest {

    @NotBlank(message = "El campo especialidad no puede estar vacio")
    private String especialidad;

    @NotNull(message = "El campo id_personal no puede estar vacio")
    private Long id_personal;

    public DocenteRequest() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Long getId_personal() {
        return id_personal;
    }

    public void setId_personal(Long id_personal) {
        this.id_personal = id_personal;
    }

}
