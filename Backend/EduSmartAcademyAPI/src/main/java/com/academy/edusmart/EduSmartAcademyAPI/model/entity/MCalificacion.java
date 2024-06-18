package com.academy.edusmart.EduSmartAcademyAPI.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_calificacion")
public class MCalificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mc")
    private Long id;

    @JoinColumn(name = "id_materia")
    @ManyToOne
    private Materia materia;

    @JoinColumn(name = "id_estudiante")
    @ManyToOne
    private Estudiante estudiante;

    @JoinColumn(name = "id_docente")
    @ManyToOne
    private Docente docente;

    public MCalificacion() {
    }

    public MCalificacion(Long id, Materia materia, Estudiante estudiante, Docente docente) {
        this.id = id;
        this.materia = materia;
        this.estudiante = estudiante;
        this.docente = docente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
