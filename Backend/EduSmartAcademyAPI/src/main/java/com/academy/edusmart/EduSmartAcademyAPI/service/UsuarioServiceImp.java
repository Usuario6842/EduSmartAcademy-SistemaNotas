package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.RolNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.UsuarioNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.UsuarioMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.UsuarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.UsuarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Rol;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Usuario;
import com.academy.edusmart.EduSmartAcademyAPI.repository.RolRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository, RolRepository rolRepository){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public List<UsuarioResponse> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponse> usuarioResponses = new ArrayList<>();

        for(Usuario usuario : usuarios) {
            usuarioResponses.add(UsuarioMapper.INSTANCE.toUsuarioResponse(usuario));
        }

        return usuarioResponses;
    }

    @Override
    public UsuarioResponse findById(Long id) {
        Optional<Usuario> usuarioOptional= usuarioRepository.findById(id);

        if(usuarioOptional.isEmpty()) throw new UsuarioNotFoundExcep();

        return UsuarioMapper.INSTANCE.toUsuarioResponse(usuarioOptional.get());
    }

    @Override
    public List<UsuarioResponse> findAllByRol(Long idRol) {
        Optional<Rol> rolOptional = rolRepository.findById(idRol);
        List<UsuarioResponse> usuarioResponses = new ArrayList<>();

        if(rolOptional.isEmpty()) throw new RolNotFoundExcep();

        List<Usuario> usuarios = usuarioRepository.findAllByRol(rolOptional.get());
        for (Usuario usuario: usuarios) {
            usuarioResponses.add(UsuarioMapper.INSTANCE.toUsuarioResponse(usuario));
        }

        return usuarioResponses;
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Optional<Rol> rolOptional = rolRepository.findById(usuarioRequest.getId_rol());

        if(rolOptional.isEmpty()) throw new RolNotFoundExcep();

        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setRol(rolOptional.get());
        Usuario usuarioSaved = usuarioRepository.save(usuario);

        return UsuarioMapper.INSTANCE.toUsuarioResponse(usuarioSaved);
    }

    @Override
    public UsuarioResponse update(Long id, UsuarioRequest usuarioRequest) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        Optional<Rol> rolOptional = rolRepository.findById(usuarioRequest.getId_rol());

        if(optionalUsuario.isEmpty()) throw new UsuarioNotFoundExcep();
        if(rolOptional.isEmpty()) throw new RolNotFoundExcep();

        Usuario usuario = optionalUsuario.get();
        usuario.setUsername(usuarioRequest.getUsername());
        usuario.setPassword(usuarioRequest.getPassword());
        usuario.setRol(rolOptional.get());
        Usuario usuarioSaved = usuarioRepository.save(usuario);

        return UsuarioMapper.INSTANCE.toUsuarioResponse(usuarioSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if(usuarioOptional.isEmpty()) throw new UsuarioNotFoundExcep();

        usuarioRepository.delete(usuarioOptional.get());
    }
}
