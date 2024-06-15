package com.academy.edusmart.EduSmartAcademyAPI.repository;

import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Aula;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.DHorario;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DHorarioRepository extends JpaRepository<DHorario, Long> {
    List<DHorario> findAllByDocente(Docente docente);
    List<DHorario> findAllByAula(Aula aula);
}
