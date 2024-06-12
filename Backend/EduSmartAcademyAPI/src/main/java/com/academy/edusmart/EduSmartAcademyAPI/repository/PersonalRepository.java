package com.academy.edusmart.EduSmartAcademyAPI.repository;

import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Cargo;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalRepository extends JpaRepository<Personal, Long> {

    List<Personal> findAllByCargo(Cargo cargo);
}
