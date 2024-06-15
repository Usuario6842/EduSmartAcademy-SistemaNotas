package com.academy.edusmart.EduSmartAcademyAPI.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DHorario")
public class DHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dh")
    private Long id;
    @Column
    private Integer periodo;

    @ManyToOne
    @JoinColumn(name = "id_mh")
    private MHorario horario;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

    public DHorario() {
    }

    public DHorario(Long id, Integer periodo, MHorario horario, Aula aula, Materia materia, Docente docente) {
        this.id = id;
        this.periodo = periodo;
        this.horario = horario;
        this.aula = aula;
        this.materia = materia;
        this.docente = docente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public MHorario getHorario() {
        return horario;
    }

    public void setHorario(MHorario horario) {
        this.horario = horario;
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
