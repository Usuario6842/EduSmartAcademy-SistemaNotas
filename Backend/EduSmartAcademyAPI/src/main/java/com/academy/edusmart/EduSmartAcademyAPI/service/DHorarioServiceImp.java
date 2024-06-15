package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.*;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.DHorarioMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DHorarioRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DHorarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.*;
import com.academy.edusmart.EduSmartAcademyAPI.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DHorarioServiceImp implements DHorarioService{

    private final DHorarioRepository dHorarioRepository;
    private final MHorarioRepository mHorarioRepository;
    private final AulaRepository aulaRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteRepository docenteRepository;

    public DHorarioServiceImp(DHorarioRepository dHorarioRepository, MHorarioRepository mHorarioRepository, AulaRepository aulaRepository, MateriaRepository materiaRepository, DocenteRepository docenteRepository){
        this.dHorarioRepository = dHorarioRepository;
        this.mHorarioRepository = mHorarioRepository;
        this.aulaRepository = aulaRepository;
        this.materiaRepository = materiaRepository;
        this.docenteRepository = docenteRepository;
    }

    @Override
    public List<DHorarioResponse> findAll() {
        List<DHorario> dHorarioList = dHorarioRepository.findAll();
        List<DHorarioResponse> responses = new ArrayList<>();

        for (DHorario dHorario : dHorarioList) {
            responses.add(DHorarioMapper.INSTANCE.toDHorarioResponse(dHorario));
        }

        return responses;
    }

    @Override
    public DHorarioResponse findById(Long id) {
        Optional<DHorario> optionalDHorario = dHorarioRepository.findById(id);

        if (optionalDHorario.isEmpty()) throw new DHorarioNotFoundExcep();

        return DHorarioMapper.INSTANCE.toDHorarioResponse(optionalDHorario.get());
    }

    @Override
    public List<DHorarioResponse> findAllByDocente(Long idDocente) {
        Optional<Docente> optionalDocente = docenteRepository.findById(idDocente);
        List<DHorarioResponse> responses = new ArrayList<>();

        if (optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();
        List<DHorario> dHorarioList = dHorarioRepository.findAllByDocente(optionalDocente.get());

        for (DHorario dHorario : dHorarioList){
            responses.add(DHorarioMapper.INSTANCE.toDHorarioResponse(dHorario));
        }

        return responses;
    }

    @Override
    public List<DHorarioResponse> findAllByAula(Long idAula) {
        Optional<Aula> optionalAula = aulaRepository.findById(idAula);
        List<DHorarioResponse> responses = new ArrayList<>();

        if (optionalAula.isEmpty()) throw new AulaNotFoundExcep();
        List<DHorario> dHorarioList = dHorarioRepository.findAllByAula(optionalAula.get());

        for (DHorario dHorario : dHorarioList){
            responses.add(DHorarioMapper.INSTANCE.toDHorarioResponse(dHorario));
        }

        return responses;
    }

    @Override
    public DHorarioResponse create(DHorarioRequest dHorarioRequest) {
        Optional<MHorario> optionalMHorario = mHorarioRepository.findById(dHorarioRequest.getId_mh());
        Optional<Aula> optionalAula = aulaRepository.findById(dHorarioRequest.getId_aula());
        Optional<Materia> optionalMateria = materiaRepository.findById(dHorarioRequest.getId_materia());
        Optional<Docente> optionalDocente = docenteRepository.findById(dHorarioRequest.getId_docente());

        if(optionalMHorario.isEmpty()) throw new MHorarioNotFoundExcep();
        if(optionalAula.isEmpty()) throw new AulaNotFoundExcep();
        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();
        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();

        DHorario dHorario = new DHorario();
        dHorario.setPeriodo(dHorarioRequest.getPeriodo());
        dHorario.setHorario(optionalMHorario.get());
        dHorario.setAula(optionalAula.get());
        dHorario.setMateria(optionalMateria.get());
        dHorario.setDocente(optionalDocente.get());
        DHorario dHorarioSaved = dHorarioRepository.save(dHorario);

        return DHorarioMapper.INSTANCE.toDHorarioResponse(dHorarioSaved);
    }

    @Override
    public DHorarioResponse update(Long id, DHorarioRequest dHorarioRequest) {
        Optional<DHorario> optionalDHorario = dHorarioRepository.findById(id);
        Optional<MHorario> optionalMHorario = mHorarioRepository.findById(dHorarioRequest.getId_mh());
        Optional<Aula> optionalAula = aulaRepository.findById(dHorarioRequest.getId_aula());
        Optional<Materia> optionalMateria = materiaRepository.findById(dHorarioRequest.getId_materia());
        Optional<Docente> optionalDocente = docenteRepository.findById(dHorarioRequest.getId_docente());

        if(optionalDHorario.isEmpty()) throw new DHorarioNotFoundExcep();
        if(optionalMHorario.isEmpty()) throw new MHorarioNotFoundExcep();
        if(optionalAula.isEmpty()) throw new AulaNotFoundExcep();
        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();
        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();

        DHorario dHorario = optionalDHorario.get();
        dHorario.setPeriodo(dHorarioRequest.getPeriodo());
        dHorario.setHorario(optionalMHorario.get());
        dHorario.setAula(optionalAula.get());
        dHorario.setMateria(optionalMateria.get());
        dHorario.setDocente(optionalDocente.get());
        DHorario dHorarioSaved = dHorarioRepository.save(dHorario);

        return DHorarioMapper.INSTANCE.toDHorarioResponse(dHorarioSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<DHorario> optionalDHorario = dHorarioRepository.findById(id);

        if (optionalDHorario.isEmpty()) throw new DHorarioNotFoundExcep();

        dHorarioRepository.delete(optionalDHorario.get());
    }
}
