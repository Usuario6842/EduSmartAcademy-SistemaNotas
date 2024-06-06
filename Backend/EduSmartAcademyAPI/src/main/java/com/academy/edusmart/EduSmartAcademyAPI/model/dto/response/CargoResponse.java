package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

public class CargoResponse {
    private Long id;
    private String nombre;
    private String descripcion;

    public CargoResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
