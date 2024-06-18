package com.academy.edusmart.EduSmartAcademyAPI.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Long id;
    @Column()
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_personal")
    private Personal personal;

    public Docente() {
    }

    public Docente(Long id, String especialidad, Personal personal) {
        this.id = id;
        this.especialidad = especialidad;
        this.personal = personal;
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

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
