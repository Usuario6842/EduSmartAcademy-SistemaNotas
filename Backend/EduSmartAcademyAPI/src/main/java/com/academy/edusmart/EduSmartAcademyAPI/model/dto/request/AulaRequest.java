package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AulaRequest {

    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "El campo grado no puede ser nulo")
    @Min(value = 0, message = "El valor minimo permitido del campo grado es 0")
    @Max(value = 100, message = "El valor maximo permitido del campo grado es 100")
    private int grado;

    @NotNull(message = "El campo paralelo no puede ser nulo")
    @NotBlank(message = "El campo paralelo no puede estar vacio")
    private String paralelo;

    public AulaRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }
}
