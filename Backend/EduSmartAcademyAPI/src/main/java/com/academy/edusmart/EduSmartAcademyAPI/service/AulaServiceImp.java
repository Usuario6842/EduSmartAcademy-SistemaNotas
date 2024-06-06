package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.AulaNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.AulaMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.AulaRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.AulaResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Aula;
import com.academy.edusmart.EduSmartAcademyAPI.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImp implements AulaService{
    private final AulaRepository aulaRepository;

    public AulaServiceImp(AulaRepository aulaRepository){
        this.aulaRepository = aulaRepository;
    }

    @Override
    public List<AulaResponse> findAll() {
        List<Aula> aulas = aulaRepository.findAll();
        List<AulaResponse> aulaResponse = new ArrayList<>();

        for(Aula aula : aulas){
            aulaResponse.add(AulaMapper.INSTANCE.toAulaResponse(aula));
        }

        return aulaResponse;
    }

    @Override
    public AulaResponse findById(Long id) {
        Optional<Aula> aulaOptional = aulaRepository.findById(id);
        AulaResponse aulaResponse;

        if(aulaOptional.isEmpty()) throw new AulaNotFoundExcep();

        return AulaMapper.INSTANCE.toAulaResponse(aulaOptional.get());
    }

    @Override
    public AulaResponse create(AulaRequest aulaRequest) {
        Aula aula = new Aula();
        aula.setNombre(aulaRequest.getNombre());
        aula.setGrado(aulaRequest.getGrado());
        aula.setParalelo(aulaRequest.getParalelo());
        Aula aulaSaved = aulaRepository.save(aula);

        return AulaMapper.INSTANCE.toAulaResponse(aulaSaved);
    }

    @Override
    public AulaResponse update(Long id, AulaRequest aulaRequest) {
        Optional<Aula> aulaOptional = aulaRepository.findById(id);

        if(aulaOptional.isEmpty()) throw new AulaNotFoundExcep();

        Aula aula = aulaOptional.get();
        aula.setNombre(aulaRequest.getNombre());
        aula.setGrado(aulaRequest.getGrado());
        aula.setParalelo(aulaRequest.getParalelo());
        Aula aulaSaved = aulaRepository.save(aula);
        return AulaMapper.INSTANCE.toAulaResponse(aulaSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Aula> aulaOptional = aulaRepository.findById(id);

        if(aulaOptional.isEmpty()) throw new AulaNotFoundExcep();

        aulaRepository.delete(aulaOptional.get());
    }
}
