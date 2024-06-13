package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class EstudianteRequest {
    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El campo apellido no puede estar vacio")
    private String apellido;
    @NotBlank(message = "El campo genero no puede estar vacio")
    private String genero;
    @NotNull(message = "El campo f_nacimiento no puede ser nulo")
    private LocalDate f_nacimiento;
    @NotNull(message = "El campo telefono no puede ser nulo")
    private Integer telefono;
    @NotNull(message = "El campo id_usuario no puede no puede ser nulo")
    private Long id_usuario;


    public EstudianteRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(LocalDate f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
