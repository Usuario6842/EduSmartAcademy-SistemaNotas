package com.academy.edusmart.EduSmartAcademyAPI.repository;

import com.academy.edusmart.EduSmartAcademyAPI.model.entity.DCalificacion;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Estudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.MCalificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DCalificacionRepository extends JpaRepository<DCalificacion, Long> {
    List<DCalificacion> findAllByCalificacion(MCalificacion mCalificacion);
}
