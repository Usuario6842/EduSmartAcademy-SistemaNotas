package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.*;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.InscripcionMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.InscripcionRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.InscripcionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.*;
import com.academy.edusmart.EduSmartAcademyAPI.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class InscripcionServiceImp implements InscripcionService{

    private final InscripcionRepository inscripcionRepository;
    private final AulaRepository aulaRepository;
    private final MateriaRepository materiaRepository;
    private final EstudianteRepository estudianteRepository;
    private final DocenteRepository docenteRepository;

    public InscripcionServiceImp(InscripcionRepository inscripcionRepository, AulaRepository aulaRepository, MateriaRepository materiaRepository, EstudianteRepository estudianteRepository, DocenteRepository docenteRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.aulaRepository = aulaRepository;
        this.materiaRepository = materiaRepository;
        this.estudianteRepository = estudianteRepository;
        this.docenteRepository = docenteRepository;
    }

    @Override
    public List<InscripcionResponse> findAll() {
        List<Inscripcion> inscripcions = inscripcionRepository.findAll();
        List<InscripcionResponse> inscripcionResponses = new ArrayList<>();

        System.out.println("valores de inscripcion"+inscripcions.size());
        for (Inscripcion inscripcion : inscripcions){
            System.out.println(inscripcion);
            inscripcionResponses.add(InscripcionMapper.INSTANCE.toInscripcionResponse(inscripcion));
        }
        return inscripcionResponses;
    }

    @Override
    public InscripcionResponse findById(Long id) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);

        if(optionalInscripcion.isEmpty()) throw new InscripcionNotFoundExcep();

        return InscripcionMapper.INSTANCE.toInscripcionResponse(optionalInscripcion.get());
    }

    @Override
    public List<InscripcionResponse> findAllByAula(Long idAula) {
        Optional<Aula> optionalAula = aulaRepository.findById(idAula);
        List<InscripcionResponse> responses= new ArrayList<>();

        if(optionalAula.isEmpty()) throw new AulaNotFoundExcep();
        List<Inscripcion> inscripcions = inscripcionRepository.findAllByAula(optionalAula.get());

        for (Inscripcion inscripcion : inscripcions){
            responses.add(InscripcionMapper.INSTANCE.toInscripcionResponse(inscripcion));
        }

        return responses;
    }

    @Override
    public List<InscripcionResponse> findAllByMateria(Long idMateria) {
        Optional<Materia> optionalMateria = materiaRepository.findById(idMateria);
        List<InscripcionResponse> responses= new ArrayList<>();

        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();
        List<Inscripcion> inscripcions = inscripcionRepository.findAllByMateria(optionalMateria.get());

        for (Inscripcion inscripcion : inscripcions){
            responses.add(InscripcionMapper.INSTANCE.toInscripcionResponse(inscripcion));
        }

        return responses;
    }

    @Override
    public List<InscripcionResponse> findAllByEstudiante(Long idEstudiante) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(idEstudiante);
        List<InscripcionResponse> responses= new ArrayList<>();

        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();
        List<Inscripcion> inscripcions = inscripcionRepository.findAllByEstudiante(optionalEstudiante.get());

        for (Inscripcion inscripcion : inscripcions){
            responses.add(InscripcionMapper.INSTANCE.toInscripcionResponse(inscripcion));
        }

        return responses;
    }

    @Override
    public List<InscripcionResponse> findAllByDocente(Long idDocente) {
        Optional<Docente> optionalDocente = docenteRepository.findById(idDocente);
        List<InscripcionResponse> responses= new ArrayList<>();

        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();
        List<Inscripcion> inscripcions = inscripcionRepository.findAllByDocente(optionalDocente.get());

        for (Inscripcion inscripcion : inscripcions){
            responses.add(InscripcionMapper.INSTANCE.toInscripcionResponse(inscripcion));
        }

        return responses;
    }

    @Override
    public List<Map<String, Object>> countInscripcionesByMateria() {
        List<Object[]> results = inscripcionRepository.countInscripcionesByMateria();
        List<Map<String, Object>> list = new ArrayList<>();

        for (Object[] result : results) {
            String idMateria = (String) result[0];
            Integer conteo = Integer.parseInt(result[1].toString());

            Map<String, Object> countMap = new HashMap<>();
            countMap.put("materia", idMateria);
            countMap.put("inscritos", conteo);

            list.add(countMap);
        }

        return list;
    }

    @Override
    public InscripcionResponse create(InscripcionRequest inscripcionRequest) {
        Optional<Aula> optionalAula = aulaRepository.findById(inscripcionRequest.getId_aula());
        Optional<Materia> optionalMateria = materiaRepository.findById(inscripcionRequest.getId_materia());
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(inscripcionRequest.getId_estudiante());
        Optional<Docente> optionalDocente = docenteRepository.findById(inscripcionRequest.getId_docente());

        if(optionalAula.isEmpty()) throw new AulaNotFoundExcep();
        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();
        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();
        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setfInscripcion(inscripcionRequest.getfInscripcion());
        inscripcion.setfInicio(inscripcionRequest.getfInicio());
        inscripcion.setfFinal(inscripcionRequest.getfFinal());
        inscripcion.setAula(optionalAula.get());
        inscripcion.setMateria(optionalMateria.get());
        inscripcion.setEstudiante(optionalEstudiante.get());
        inscripcion.setDocente(optionalDocente.get());
        Inscripcion inscripcionSaved = inscripcionRepository.save(inscripcion);

        return InscripcionMapper.INSTANCE.toInscripcionResponse(inscripcionSaved);
    }

    @Override
    public InscripcionResponse update(Long id, InscripcionRequest inscripcionRequest) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);
        Optional<Aula> optionalAula = aulaRepository.findById(inscripcionRequest.getId_aula());
        Optional<Materia> optionalMateria = materiaRepository.findById(inscripcionRequest.getId_materia());
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(inscripcionRequest.getId_estudiante());
        Optional<Docente> optionalDocente = docenteRepository.findById(inscripcionRequest.getId_docente());

        if(optionalInscripcion.isEmpty()) throw new InscripcionNotFoundExcep();
        if(optionalAula.isEmpty()) throw new AulaNotFoundExcep();
        if(optionalMateria.isEmpty()) throw new MateriaNotFoundExcep();
        if(optionalEstudiante.isEmpty()) throw new EstudianteNotFoundExcep();
        if(optionalDocente.isEmpty()) throw new DocenteNotFoundExcep();

        Inscripcion inscripcion = optionalInscripcion.get();
        inscripcion.setfInscripcion(inscripcionRequest.getfInscripcion());
        inscripcion.setfInicio(inscripcionRequest.getfInicio());
        inscripcion.setfFinal(inscripcionRequest.getfFinal());
        inscripcion.setAula(optionalAula.get());
        inscripcion.setMateria(optionalMateria.get());
        inscripcion.setEstudiante(optionalEstudiante.get());
        inscripcion.setDocente(optionalDocente.get());
        Inscripcion inscripcionSaved = inscripcionRepository.save(inscripcion);

        return InscripcionMapper.INSTANCE.toInscripcionResponse(inscripcionSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Inscripcion> optionalInscripcion = inscripcionRepository.findById(id);

        if(optionalInscripcion.isEmpty()) throw new InscripcionNotFoundExcep();

        inscripcionRepository.delete(optionalInscripcion.get());
    }
}
