package com.academy.edusmart.EduSmartAcademyAPI.repository;

import com.academy.edusmart.EduSmartAcademyAPI.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findAllByAula(Aula aula);
    List<Inscripcion> findAllByMateria(Materia materia);
    List<Inscripcion> findAllByEstudiante(Estudiante estudiante);
    List<Inscripcion> findAllByDocente(Docente docente);

    @Query("SELECT m.nombre, COUNT(i) FROM Inscripcion i JOIN i.materia m GROUP BY m.nombre")
    List<Object[]> countInscripcionesByMateria();
}
