package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.EstudianteNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.UsuarioNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.EstudianteMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.EstudianteRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.EstudianteResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Estudiante;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Usuario;
import com.academy.edusmart.EduSmartAcademyAPI.repository.EstudianteRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImp implements EstudianteService{

    private final EstudianteRepository estudianteRepository;
    private final UsuarioRepository usuarioRepository;

    public EstudianteServiceImp(EstudianteRepository estudianteRepository, UsuarioRepository usuarioRepository) {
        this.estudianteRepository = estudianteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<EstudianteResponse> findAll() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        List<EstudianteResponse> estudianteResponses = new ArrayList<>();

        for(Estudiante estudiante : estudiantes) {
            estudianteResponses.add(EstudianteMapper.INSTANCE.toEstudianteResponse(estudiante));
        }

        return estudianteResponses;
    }

    @Override
    public EstudianteResponse findById(Long id) {

        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);

        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();

        return EstudianteMapper.INSTANCE.toEstudianteResponse(optionalEstudiante.get());
    }

    @Override
    public EstudianteResponse create(EstudianteRequest estudianteRequest) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(estudianteRequest.getId_usuario());
        Optional<Estudiante> estudianteOptional;

        if(usuarioOptional.isEmpty()) throw new UsuarioNotFoundExcep();

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setApellido(estudianteRequest.getApellido());
        estudiante.setGenero(estudianteRequest.getGenero());
        estudiante.setF_nacimiento(estudianteRequest.getF_nacimiento());
        estudiante.setTelefono(estudianteRequest.getTelefono());
        estudiante.setUsuario(usuarioOptional.get());

        Estudiante estudianteSaved = estudianteRepository.save(estudiante);


        return EstudianteMapper.INSTANCE.toEstudianteResponse(estudianteSaved);
    }

    @Override
    public EstudianteResponse update(Long id, EstudianteRequest estudianteRequest) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(estudianteRequest.getId_usuario());

        if (estudianteOptional.isEmpty()) throw new EstudianteNotFoundExcep();
        if (usuarioOptional.isEmpty()) throw new EstudianteNotFoundExcep();

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setApellido(estudianteRequest.getApellido());
        estudiante.setGenero(estudianteRequest.getGenero());
        estudiante.setF_nacimiento(estudianteRequest.getF_nacimiento());
        estudiante.setTelefono(estudianteRequest.getTelefono());
        estudiante.setUsuario(usuarioOptional.get());

        Estudiante estudianteSaved = estudianteRepository.save(estudiante);
        return EstudianteMapper.INSTANCE.toEstudianteResponse(estudianteSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);

        if(estudianteOptional.isEmpty()) throw new EstudianteNotFoundExcep();

        estudianteRepository.delete(estudianteOptional.get());
    }
}
