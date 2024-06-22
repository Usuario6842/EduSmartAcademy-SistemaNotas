package com.academy.edusmart.EduSmartAcademyAPI.repository;

import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Rol;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findAllByRol(Rol rol);
    Optional<Usuario> findByUsername(String username);
}
