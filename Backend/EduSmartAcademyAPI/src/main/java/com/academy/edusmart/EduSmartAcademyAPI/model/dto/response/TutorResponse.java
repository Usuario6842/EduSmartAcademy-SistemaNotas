package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TutorResponse {
    private Long id;
    private Integer ci;
    private String nombre;
    private String apellido;
    private String parentesco;
    private Integer telefono;
    private String direccion;
    private EstudianteResponse estudiante;

    public TutorResponse(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
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

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EstudianteResponse getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteResponse estudiante) {
        this.estudiante = estudiante;
    }
}
