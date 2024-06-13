package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.EstudianteNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.TutorNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.TutorMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.TutorRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.TutorResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Estudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Tutor;
import com.academy.edusmart.EduSmartAcademyAPI.repository.EstudianteRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImp implements TutorService{

    private final TutorRepository tutorRepository;
    private final EstudianteRepository estudianteRepository;

    public TutorServiceImp(TutorRepository tutorRepository, EstudianteRepository estudianteRepository) {
        this.tutorRepository = tutorRepository;
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<TutorResponse> findAll() {
        List<TutorResponse> tutorResponses = new ArrayList<>();
        List<Tutor> tutors = tutorRepository.findAll();

        for (Tutor tutor : tutors) {
            tutorResponses.add(TutorMapper.INSTANCE.toTutorResponse(tutor));
        }
        return tutorResponses;
    }

    @Override
    public TutorResponse findById(Long id) {
        Optional<Tutor> optionalTutor = tutorRepository.findById(id);

        if(optionalTutor.isEmpty()) throw new TutorNotFoundExcep();

        return TutorMapper.INSTANCE.toTutorResponse(optionalTutor.get());
    }

    @Override
    public List<TutorResponse> findAllByEstudiante(Long idEstudiante) {
        List<TutorResponse> tutorResponses = new ArrayList<>();
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(idEstudiante);

        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();

        List<Tutor> tutors = tutorRepository.findAllByEstudiante(optionalEstudiante.get());

        for (Tutor tutor : tutors) {
            tutorResponses.add(TutorMapper.INSTANCE.toTutorResponse(tutor));
        }
        return tutorResponses;
    }

    @Override
    public TutorResponse create(TutorRequest tutorRequest) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(tutorRequest.getId_estudiante());

        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();

        Tutor tutor = new Tutor();
        tutor.setCi(tutorRequest.getCi());
        tutor.setNombre(tutorRequest.getNombre());
        tutor.setApellido(tutorRequest.getApellido());
        tutor.setParentesco(tutorRequest.getParentesco());
        tutor.setTelefono(tutorRequest.getTelefono());
        tutor.setDireccion(tutorRequest.getDireccion());
        tutor.setEstudiante(optionalEstudiante.get());
        Tutor tutorSaved = tutorRepository.save(tutor);

        return TutorMapper.INSTANCE.toTutorResponse(tutorSaved);
    }

    @Override
    public TutorResponse update(Long id, TutorRequest tutorRequest) {

        Optional<Tutor> optionalTutor = tutorRepository.findById(id);
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(tutorRequest.getId_estudiante());

        if(optionalTutor.isEmpty()) throw new TutorNotFoundExcep();
        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();

        Tutor tutor = optionalTutor.get();
        tutor.setCi(tutorRequest.getCi());
        tutor.setNombre(tutorRequest.getNombre());
        tutor.setApellido(tutorRequest.getApellido());
        tutor.setParentesco(tutorRequest.getParentesco());
        tutor.setTelefono(tutorRequest.getTelefono());
        tutor.setDireccion(tutorRequest.getDireccion());
        tutor.setEstudiante(optionalEstudiante.get());
        Tutor tutorSaved = tutorRepository.save(tutor);

        return TutorMapper.INSTANCE.toTutorResponse(tutorSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Tutor> optionalTutor =tutorRepository.findById(id);

        if(optionalTutor.isEmpty()) throw new TutorNotFoundExcep();

        tutorRepository.delete(optionalTutor.get());
    }
}
