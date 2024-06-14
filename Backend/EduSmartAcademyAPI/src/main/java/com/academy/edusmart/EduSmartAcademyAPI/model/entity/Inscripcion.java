package com.academy.edusmart.EduSmartAcademyAPI.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "InscripcionMateria")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_est_mat")
    private Long id;
    @Column(name = "f_inscription")
    private LocalDate fInscripcion;
    @Column(name = "f_inicio")
    private LocalDate fInicio;
    @Column(name = "f_final")
    private LocalDate fFinal;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

    public Inscripcion() {
    }

    public Inscripcion(Long id, LocalDate fInscripcion, LocalDate fInicio, LocalDate fFinal, Aula aula, Materia materia, Estudiante estudiante, Docente docente) {
        this.id = id;
        this.fInscripcion = fInscripcion;
        this.fInicio = fInicio;
        this.fFinal = fFinal;
        this.aula = aula;
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

    public LocalDate getfInscripcion() {
        return fInscripcion;
    }

    public void setfInscripcion(LocalDate fInscripcion) {
        this.fInscripcion = fInscripcion;
    }

    public LocalDate getfInicio() {
        return fInicio;
    }

    public void setfInicio(LocalDate fInicio) {
        this.fInicio = fInicio;
    }

    public LocalDate getfFinal() {
        return fFinal;
    }

    public void setfFinal(LocalDate fFinal) {
        this.fFinal = fFinal;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
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
