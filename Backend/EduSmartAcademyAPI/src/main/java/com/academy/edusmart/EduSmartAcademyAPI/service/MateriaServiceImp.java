package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.mapper.MateriaMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MateriaRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MateriaResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Materia;
import com.academy.edusmart.EduSmartAcademyAPI.repository.MateriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImp implements MateriaService{

    private final MateriaRepository materiaRepository;

    public MateriaServiceImp(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public List<MateriaResponse> findAll() {
        List<Materia> materias = materiaRepository.findAll();
        List<MateriaResponse> materiaResponses = new ArrayList<>();

        for(Materia materia : materias) {
            materiaResponses.add(MateriaMapper.INSTANCE.toMateriaResponse(materia));
        }

        return materiaResponses;
    }

    @Override
    public MateriaResponse findById(long id) {
        Optional<Materia> materiaOptional = materiaRepository.findById(id);
        MateriaResponse materiaResponse;

        if(materiaOptional.isEmpty()) throw new RuntimeException();
        return MateriaMapper.INSTANCE.toMateriaResponse(materiaOptional.get());
    }

    @Override
    public MateriaResponse create(MateriaRequest materiaRequest) {
        Materia materia = new Materia();
        materia.setNombre(materiaRequest.getNombre());
        materia.setDescripcion(materiaRequest.getDescripcion());
        Materia materiaSaved = materiaRepository.save(materia);

        return MateriaMapper.INSTANCE.toMateriaResponse(materiaSaved);
    }

    @Override
    public MateriaResponse update(Long id, MateriaRequest materiaRequest) {
        Optional<Materia> materiaOptional = materiaRepository.findById(id);

        if(materiaOptional.isEmpty()) throw new RuntimeException();

        Materia materia = materiaOptional.get();
        materia.setNombre(materiaRequest.getNombre());
        materia.setDescripcion(materiaRequest.getDescripcion());
        Materia materiaSaved = materiaRepository.save(materia);

        return MateriaMapper.INSTANCE.toMateriaResponse(materiaSaved);
    }

    @Override
    public void delete(long id) {
        Optional<Materia> materiaOptional = materiaRepository.findById(id);

        if(materiaOptional.isEmpty()) throw new RuntimeException();

        materiaRepository.delete(materiaOptional.get());
    }
}
