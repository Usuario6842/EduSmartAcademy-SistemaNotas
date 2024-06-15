package com.academy.edusmart.EduSmartAcademyAPI.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MHorario")
public class MHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mh")
    private Long id;
    @Column
    private String dia;
    @Column
    private Integer gestion;

    public MHorario() {
    }

    public MHorario(Long id, String dia, Integer gestion) {
        this.id = id;
        this.dia = dia;
        this.gestion = gestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }
}
