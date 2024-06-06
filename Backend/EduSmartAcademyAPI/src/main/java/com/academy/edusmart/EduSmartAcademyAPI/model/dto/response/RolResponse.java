package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

public class RolResponse {
    private long id;
    private String nombre;
    private String descripcion;

    public RolResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
