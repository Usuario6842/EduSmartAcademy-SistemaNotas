package com.academy.edusmart.EduSmartAcademyAPI.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "d_calificacion")
public class DCalificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dc")
    private Long id;
    @Column(name = "n_ser")
    private Double ser;
    @Column(name = "n_saber")
    private Double saber;
    @Column(name = "n_hacer")
    private Double hacer;
    @Column(name = "n_decidir")
    private Double decidir;
    @Column()
    private Double autoevaluacion;
    @Column(name = "n_final")
    private Double notaFinal;

    @ManyToOne
    @JoinColumn(name = "id_mc")
    private MCalificacion calificacion;

    public DCalificacion() {
    }

    public DCalificacion(Long id, Double ser, Double saber, Double hacer, Double decidir, Double autoevaluacion, Double notaFinal, MCalificacion calificacion) {
        this.id = id;
        this.ser = ser;
        this.saber = saber;
        this.hacer = hacer;
        this.decidir = decidir;
        this.autoevaluacion = autoevaluacion;
        this.notaFinal = notaFinal;
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSer() {
        return ser;
    }

    public void setSer(Double ser) {
        this.ser = ser;
    }

    public Double getSaber() {
        return saber;
    }

    public void setSaber(Double saber) {
        this.saber = saber;
    }

    public Double getHacer() {
        return hacer;
    }

    public void setHacer(Double hacer) {
        this.hacer = hacer;
    }

    public Double getDecidir() {
        return decidir;
    }

    public void setDecidir(Double decidir) {
        this.decidir = decidir;
    }

    public Double getAutoevaluacion() {
        return autoevaluacion;
    }

    public void setAutoevaluacion(Double autoevaluacion) {
        this.autoevaluacion = autoevaluacion;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public MCalificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(MCalificacion calificacion) {
        this.calificacion = calificacion;
    }
}
