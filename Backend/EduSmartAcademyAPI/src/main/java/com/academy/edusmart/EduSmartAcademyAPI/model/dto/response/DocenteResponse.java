package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

public class DocenteResponse {
    private Long id;
    private String especialidad;
    private PersonalResponse personal;

    public DocenteResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public PersonalResponse getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalResponse personal) {
        this.personal = personal;
    }
}
