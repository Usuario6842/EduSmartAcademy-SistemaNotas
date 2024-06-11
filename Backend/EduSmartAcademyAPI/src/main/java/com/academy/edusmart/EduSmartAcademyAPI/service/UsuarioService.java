package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.UsuarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioResponse> findAll();
    public UsuarioResponse findById(Long id);
    public List<UsuarioResponse> findAllByRol(Long idRol);
    public UsuarioResponse create(UsuarioRequest usuarioRequest);
    public UsuarioResponse update(Long id, UsuarioRequest usuarioRequest);
    public void delete(Long id);

}
