package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.simpleResponse.SimpleDocente;

public class DHorarioResponse {
    private Long id;
    private String gestion;
    private String dia;
    private Integer periodo;
    private Long idAula;
    private String aula;
    private Long idMateria;
    private String materia;
    private SimpleDocente docente;

    public DHorarioResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public SimpleDocente getDocente() {
        return docente;
    }

    public void setDocente(SimpleDocente docente) {
        this.docente = docente;
    }
}
