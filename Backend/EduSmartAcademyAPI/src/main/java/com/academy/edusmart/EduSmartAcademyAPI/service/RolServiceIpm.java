package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.mapper.RolMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.RolRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.RolResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Rol;
import com.academy.edusmart.EduSmartAcademyAPI.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceIpm implements RolService{

    private final RolRepository rolRepository;

    public RolServiceIpm(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolResponse> findAll() {
        List<Rol> roles = rolRepository.findAll();
        List<RolResponse> rolResponses = new ArrayList<>();

        for (Rol rol : roles) {
            rolResponses.add(RolMapper.INSTANCE.toRolResponse(rol));
        }

        return rolResponses;
    }


    @Override
    public RolResponse findById(long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        RolResponse rolResponse;

        if(rolOptional.isEmpty()) throw new RuntimeException();
        return RolMapper.INSTANCE.toRolResponse(rolOptional.get());
    }

    @Override
    public RolResponse create(RolRequest rolRequest) {
        Rol rol = new Rol();
        rol.setNombre(rolRequest.getNombre());
        rol.setDescripcion(rolRequest.getDescripcion());
        Rol rolsaved = rolRepository.save(rol);

        return RolMapper.INSTANCE.toRolResponse(rolsaved);
    }

    @Override
    public RolResponse update(Long id, RolRequest rolRequest) {
        Optional<Rol> rolOptional = rolRepository.findById(id);

        if(rolOptional.isEmpty()) throw new RuntimeException();

        Rol rol = rolOptional.get();
        rol.setNombre(rolRequest.getNombre());
        rol.setDescripcion(rolRequest.getDescripcion());

        Rol rolSaved = rolRepository.save(rol);

        return RolMapper.INSTANCE.toRolResponse(rolSaved);
    }

    @Override
    public void delete(long id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);

        if(rolOptional.isEmpty()) throw new RuntimeException();

        rolRepository.delete(rolOptional.get());
    }
}
