package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.DocenteNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.PersonalNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.DocenteMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DocenteRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DocenteResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.PersonalResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Docente;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Personal;
import com.academy.edusmart.EduSmartAcademyAPI.repository.DocenteRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.PersonalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocenteServiceImp implements DocenteService{

    private final DocenteRepository docenteRepository;
    private final PersonalRepository personalRepository;

    public DocenteServiceImp(DocenteRepository docenteRepository, PersonalRepository personalRepository) {
        this.docenteRepository = docenteRepository;
        this.personalRepository = personalRepository;
    }

    @Override
    public List<DocenteResponse> findAll() {
        List<Docente> docentes = docenteRepository.findAll();
        List<DocenteResponse> docenteResponses= new ArrayList<>();

        for(Docente docente : docentes) {
            docenteResponses.add(DocenteMapper.INSTANCE.toDocenteResponse(docente));
        }

        return docenteResponses;
    }

    @Override
    public DocenteResponse findById(Long id) {
        Optional<Docente> docenteOptional = docenteRepository.findById(id);

        if(docenteOptional.isEmpty()) throw new DocenteNotFoundExcep();

        return DocenteMapper.INSTANCE.toDocenteResponse(docenteOptional.get());
    }

    @Override
    public DocenteResponse create(DocenteRequest docenteRequest) {
        Optional<Personal> optionalPersonal= personalRepository.findById(docenteRequest.getId_personal());

        if(optionalPersonal.isEmpty()) throw new PersonalNotFoundExcep();

        Docente docente = new Docente();
        docente.setEspecialidad(docenteRequest.getEspecialidad());
        docente.setPersonal(optionalPersonal.get());
        Docente docenteSaved = docenteRepository.save(docente);

        return DocenteMapper.INSTANCE.toDocenteResponse(docenteSaved);
    }

    @Override
    public DocenteResponse update(Long id, DocenteRequest docenteRequest) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);
        Optional<Personal> optionalPersonal= personalRepository.findById(docenteRequest.getId_personal());

        if(optionalPersonal.isEmpty()) throw new DocenteNotFoundExcep();
        if(optionalDocente.isEmpty()) throw new PersonalNotFoundExcep();

        Docente docente = optionalDocente.get();
        docente.setEspecialidad(docenteRequest.getEspecialidad());
        docente.setPersonal(optionalPersonal.get());
        Docente docenteSaved = docenteRepository.save(docente);

        return DocenteMapper.INSTANCE.toDocenteResponse(docenteSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);

        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();

        docenteRepository.delete(optionalDocente.get());
    }
}
