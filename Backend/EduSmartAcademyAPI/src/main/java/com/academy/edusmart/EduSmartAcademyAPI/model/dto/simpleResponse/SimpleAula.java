package com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse;

public class SimpleAula {
    private Long id;
    private String nombre;

    public SimpleAula() {
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
}
