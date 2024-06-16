package com.academy.edusmart.EduSmartAcademyAPI.repository;

import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Estudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.MCalificacion;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MCalificacionRepository extends JpaRepository<MCalificacion, Long> {
    List<MCalificacion> findAllByMateria(Materia materia);
    List<MCalificacion> findAllByEstudiante(Estudiante estudiante);
}
