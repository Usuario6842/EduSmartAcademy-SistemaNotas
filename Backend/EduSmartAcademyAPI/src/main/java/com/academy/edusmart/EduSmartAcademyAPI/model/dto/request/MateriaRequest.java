package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MateriaRequest {

    @NotNull(message = "El calpo nombre no puede ser nulo")
    @NotBlank(message = "El calpo nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "El calpo nombre no puede ser nulo")
    @NotBlank(message = "El calpo nombre no puede estar vacio")
    private String descripcion;

    public MateriaRequest() {
    }

    public @NotNull(message = "El calpo nombre no puede ser nulo") @NotBlank(message = "El calpo nombre no puede estar vacio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull(message = "El calpo nombre no puede ser nulo") @NotBlank(message = "El calpo nombre no puede estar vacio") String nombre) {
        this.nombre = nombre;
    }

    public @NotNull(message = "El calpo nombre no puede ser nulo") @NotBlank(message = "El calpo nombre no puede estar vacio") String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull(message = "El calpo nombre no puede ser nulo") @NotBlank(message = "El calpo nombre no puede estar vacio") String descripcion) {
        this.descripcion = descripcion;
    }
}
