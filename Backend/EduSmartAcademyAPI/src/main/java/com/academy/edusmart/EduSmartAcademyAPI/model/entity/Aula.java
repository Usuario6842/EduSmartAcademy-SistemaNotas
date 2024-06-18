package com.academy.edusmart.EduSmartAcademyAPI.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long id;
    @Column
    private String nombre;
    @Column
    private int grado;
    @Column
    private String paralelo;

    public Aula() {
    }

    public Aula(Long id, String nombre, int grado, String paralelo) {
        this.id = id;
        this.nombre = nombre;
        this.grado = grado;
        this.paralelo = paralelo;
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
