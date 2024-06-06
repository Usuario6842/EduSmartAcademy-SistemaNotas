package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CargoRequest {

    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "El campo descripcion no puede ser nulo")
    @NotBlank(message = "El campo descripcion no puede estar vacio")
    private String descripcion;

    public CargoRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
