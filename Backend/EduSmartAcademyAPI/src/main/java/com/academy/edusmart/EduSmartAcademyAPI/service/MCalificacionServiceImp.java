package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.DocenteNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.EstudianteNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.MCalificacionNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.MateriaNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.MCalificacionMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.MCalificacionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MCalificacionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Docente;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Estudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.MCalificacion;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Materia;
import com.academy.edusmart.EduSmartAcademyAPI.repository.DocenteRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.EstudianteRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.MCalificacionRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.MateriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MCalificacionServiceImp implements MCalificacionService{

    private final MCalificacionRepository mCalificacionRepository;
    private final MateriaRepository materiaRepository;
    private final DocenteRepository docenteRepository;
    private final EstudianteRepository estudianteRepository;

    public MCalificacionServiceImp(MCalificacionRepository mCalificacionRepository, MateriaRepository materiaRepository, DocenteRepository docenteRepository, EstudianteRepository estudianteRepository ){
        this.mCalificacionRepository = mCalificacionRepository;
        this.materiaRepository = materiaRepository;
        this.docenteRepository = docenteRepository;
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<MCalificacionResponse> findAll() {
        List<MCalificacion> mCalificacionList = mCalificacionRepository.findAll();
        List<MCalificacionResponse> responses = new ArrayList<>();

        for (MCalificacion mCalificacion: mCalificacionList) {
            responses.add(MCalificacionMapper.INSTANCE.toMCalificacionResponse(mCalificacion));
        }

        return responses;
    }

    @Override
    public MCalificacionResponse findById(Long id) {
        Optional<MCalificacion> optionalMCalificacion= mCalificacionRepository.findById(id);

        if(optionalMCalificacion.isEmpty()) throw new MCalificacionNotFoundExcep();

        return MCalificacionMapper.INSTANCE.toMCalificacionResponse(optionalMCalificacion.get());
    }

    @Override
    public List<MCalificacionResponse> findAllByMateria(Long idMat) {
        Optional<Materia> optionalMateria = materiaRepository.findById(idMat);
        List<MCalificacionResponse> responses = new ArrayList<>();

        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();

        List<MCalificacion> mCalificacionList = mCalificacionRepository.findAllByMateria(optionalMateria.get());

        for (MCalificacion mCalificacion: mCalificacionList) {
            responses.add(MCalificacionMapper.INSTANCE.toMCalificacionResponse(mCalificacion));
        }

        return responses;
    }

    @Override
    public List<MCalificacionResponse> findAllByEstudiante(Long idEst) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(idEst);
        List<MCalificacionResponse> responses = new ArrayList<>();

        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();

        List<MCalificacion> mCalificacionList = mCalificacionRepository.findAllByEstudiante(optionalEstudiante.get());

        for (MCalificacion mCalificacion: mCalificacionList) {
            responses.add(MCalificacionMapper.INSTANCE.toMCalificacionResponse(mCalificacion));
        }

        return responses;
    }

    @Override
    public MCalificacionResponse create(MCalificacionRequest mCalificacionRequest) {
        Optional<Materia> optionalMateria = materiaRepository.findById(mCalificacionRequest.getId_materia());
        Optional<Docente> optionalDocente = docenteRepository.findById(mCalificacionRequest.getId_docente());
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(mCalificacionRequest.getId_estudiante());

        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();
        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();
        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();

        MCalificacion mCalificacion = new MCalificacion();
        mCalificacion.setMateria(optionalMateria.get());
        mCalificacion.setDocente(optionalDocente.get());
        mCalificacion.setEstudiante(optionalEstudiante.get());
        MCalificacion mCalificacionSaved = mCalificacionRepository.save(mCalificacion);

        return MCalificacionMapper.INSTANCE.toMCalificacionResponse(mCalificacionSaved);
    }

    @Override
    public MCalificacionResponse update(Long id, MCalificacionRequest mCalificacionRequest) {
        Optional<MCalificacion> optionalMCalificacion = mCalificacionRepository.findById(id);
        Optional<Materia> optionalMateria = materiaRepository.findById(mCalificacionRequest.getId_materia());
        Optional<Docente> optionalDocente = docenteRepository.findById(mCalificacionRequest.getId_docente());
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(mCalificacionRequest.getId_estudiante());

        if(optionalMCalificacion.isEmpty()) throw new MCalificacionNotFoundExcep();
        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();
        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();
        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();

        MCalificacion mCalificacion = optionalMCalificacion.get();
        mCalificacion.setMateria(optionalMateria.get());
        mCalificacion.setDocente(optionalDocente.get());
        mCalificacion.setEstudiante(optionalEstudiante.get());
        MCalificacion mCalificacionSaved = mCalificacionRepository.save(mCalificacion);

        return MCalificacionMapper.INSTANCE.toMCalificacionResponse(mCalificacionSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<MCalificacion> optionalMCalificacion = mCalificacionRepository.findById(id);

        if(optionalMCalificacion.isEmpty()) throw new MCalificacionNotFoundExcep();

        mCalificacionRepository.delete(optionalMCalificacion.get());
    }
}
