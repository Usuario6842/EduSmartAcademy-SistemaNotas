package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.DCalificacionNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.MCalificacionNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.DCalificacionMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.DCalificacionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DCalificacionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.DCalificacion;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.MCalificacion;
import com.academy.edusmart.EduSmartAcademyAPI.repository.DCalificacionRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.MCalificacionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DCalificacionServiceImp implements DCalificacionService{

    private final DCalificacionRepository dCalificacionRepository;
    private final MCalificacionRepository mCalificacionRepository;

    public DCalificacionServiceImp(DCalificacionRepository dCalificacionRepository, MCalificacionRepository mCalificacionRepository){
        this.dCalificacionRepository = dCalificacionRepository;
        this.mCalificacionRepository = mCalificacionRepository;
    }

    @Override
    public List<DCalificacionResponse> findAll() {
        List<DCalificacion> dCalificacionList = dCalificacionRepository.findAll();
        List<DCalificacionResponse> responses = new ArrayList<>();

        for (DCalificacion dCalificacion: dCalificacionList) {
            responses.add(DCalificacionMapper.INSTANCE.toDCalificacionResponse(dCalificacion));
        }

        return responses;
    }

    @Override
    public DCalificacionResponse findById(Long id) {
        Optional<DCalificacion> optionalDCalificacion = dCalificacionRepository.findById(id);

        if(optionalDCalificacion.isEmpty()) throw new DCalificacionNotFoundExcep();

        return DCalificacionMapper.INSTANCE.toDCalificacionResponse(optionalDCalificacion.get());
    }

    @Override
    public List<DCalificacionResponse> findAllByCalificacion(Long idCal) {
        Optional<MCalificacion> optionalMCalificacion = mCalificacionRepository.findById(idCal);
        List<DCalificacionResponse> responses = new ArrayList<>();

        if(optionalMCalificacion.isEmpty()) throw new MCalificacionNotFoundExcep();

        List<DCalificacion> dCalificacionList = dCalificacionRepository.findAllByCalificacion(optionalMCalificacion.get());

        for (DCalificacion dCalificacion : dCalificacionList){
            responses.add(DCalificacionMapper.INSTANCE.toDCalificacionResponse(dCalificacion));
        }

        return responses;
    }

    @Override
    public DCalificacionResponse create(DCalificacionRequest dCalificacionRequest) {

        Optional<MCalificacion> optionalMCalificacion = mCalificacionRepository.findById(dCalificacionRequest.getId_calificacion());

        if(optionalMCalificacion.isEmpty()) throw new MCalificacionNotFoundExcep();

        DCalificacion dCalificacion = new DCalificacion();
        dCalificacion.setSer(dCalificacionRequest.getSer());
        dCalificacion.setSaber(dCalificacionRequest.getSaber());
        dCalificacion.setHacer(dCalificacionRequest.getHacer());
        dCalificacion.setDecidir(dCalificacionRequest.getDecidir());
        dCalificacion.setAutoevaluacion(dCalificacionRequest.getAutoevaluacion());
        dCalificacion.setNotaFinal(dCalificacionRequest.getNotafinal());
        dCalificacion.setCalificacion(optionalMCalificacion.get());
        DCalificacion dCalificacionSaved = dCalificacionRepository.save(dCalificacion);

        return DCalificacionMapper.INSTANCE.toDCalificacionResponse(dCalificacionSaved);
    }

    @Override
    public DCalificacionResponse update(Long id, DCalificacionRequest dCalificacionRequest) {
        Optional<DCalificacion> optionalDCalificacion = dCalificacionRepository.findById(id);
        Optional<MCalificacion> optionalMCalificacion = mCalificacionRepository.findById(dCalificacionRequest.getId_calificacion());

        if(optionalDCalificacion.isEmpty()) throw new DCalificacionNotFoundExcep();
        if(optionalMCalificacion.isEmpty()) throw new MCalificacionNotFoundExcep();

        DCalificacion dCalificacion = optionalDCalificacion.get();
        dCalificacion.setSer(dCalificacionRequest.getSer());
        dCalificacion.setSaber(dCalificacionRequest.getSaber());
        dCalificacion.setHacer(dCalificacionRequest.getHacer());
        dCalificacion.setDecidir(dCalificacionRequest.getDecidir());
        dCalificacion.setAutoevaluacion(dCalificacionRequest.getAutoevaluacion());
        dCalificacion.setNotaFinal(dCalificacionRequest.getNotafinal());
        dCalificacion.setCalificacion(optionalMCalificacion.get());
        DCalificacion dCalificacionSaved = dCalificacionRepository.save(dCalificacion);

        return DCalificacionMapper.INSTANCE.toDCalificacionResponse(dCalificacionSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<DCalificacion> optionalDCalificacion = dCalificacionRepository.findById(id);

        if(optionalDCalificacion.isEmpty()) throw new DCalificacionNotFoundExcep();

        dCalificacionRepository.delete(optionalDCalificacion.get());
    }
}
