package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.CargoNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.PersonalNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.exceptions.UsuarioNotFoundExcep;
import com.academy.edusmart.EduSmartAcademyAPI.mapper.PersonalMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.PersonalRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.PersonalResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Cargo;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Personal;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Usuario;
import com.academy.edusmart.EduSmartAcademyAPI.repository.CargoRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.PersonalRepository;
import com.academy.edusmart.EduSmartAcademyAPI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImp implements PersonalService{

    private final PersonalRepository personalRepository;
    private final CargoRepository cargoRepository;
    private final UsuarioRepository usuarioRepository;

    public PersonalServiceImp(PersonalRepository personalRepository, CargoRepository cargoRepository, UsuarioRepository usuarioRepository){
        this.personalRepository = personalRepository;
        this.cargoRepository = cargoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<PersonalResponse> findAll() {
        List<Personal> personals = personalRepository.findAll();
        List<PersonalResponse> personalResponses = new ArrayList<>();

        for(Personal personal: personals){
            personalResponses.add(PersonalMapper.INSTANCE.toPersonalResponse(personal));
        }

        return personalResponses;
    }

    @Override
    public PersonalResponse findById(Long id) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);

        if(optionalPersonal.isEmpty()) throw new PersonalNotFoundExcep();

        return PersonalMapper.INSTANCE.toPersonalResponse(optionalPersonal.get());
    }

    @Override
    public List<PersonalResponse> findAllByCargo(Long idCargo) {
        Optional<Cargo> cargoOptional = cargoRepository.findById(idCargo);
        List<PersonalResponse> personalResponses = new ArrayList<>();

        if(cargoOptional.isEmpty()) throw new CargoNotFoundExcep();

        List<Personal> personals = personalRepository.findAllByCargo(cargoOptional.get());

        for (Personal personal:  personals) {
            personalResponses.add(PersonalMapper.INSTANCE.toPersonalResponse(personal));
        }

        return personalResponses;
    }

    @Override
    public PersonalResponse create(PersonalRequest personalRequest) {
        Optional<Cargo> cargoOptional = cargoRepository.findById(personalRequest.getId_cargo());
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(personalRequest.getId_usuario());

        if(cargoOptional.isEmpty()) throw new CargoNotFoundExcep();

        if(usuarioOptional.isEmpty()) throw new UsuarioNotFoundExcep();

        Personal personal = new Personal();
        personal.setCi(personalRequest.getCi());
        personal.setNombre(personalRequest.getNombre());
        personal.setApellido(personalRequest.getApellido());
        personal.setGenero(personalRequest.getGenero());
        personal.setF_nacimiento(personalRequest.getF_nacimiento());
        personal.setTelefono(personalRequest.getTelefono());
        personal.setDireccion(personalRequest.getDireccion());
        personal.setCargo(cargoOptional.get());
        personal.setUsuario(usuarioOptional.get());

        Personal personalSaved = personalRepository.save(personal);

        return PersonalMapper.INSTANCE.toPersonalResponse(personalSaved);
    }

    @Override
    public PersonalResponse update(Long id, PersonalRequest personalRequest) {
        Optional<Personal> personalOptional = personalRepository.findById(id);
        Optional<Cargo> cargoOptional = cargoRepository.findById(personalRequest.getId_cargo());
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(personalRequest.getId_usuario());

        if(personalOptional.isEmpty()) throw new PersonalNotFoundExcep();
        if(cargoOptional.isEmpty()) throw new CargoNotFoundExcep();
        if(usuarioOptional.isEmpty()) throw new UsuarioNotFoundExcep();

        Personal personal = personalOptional.get();
        personal.setCi(personalRequest.getCi());
        personal.setNombre(personalRequest.getNombre());
        personal.setApellido(personalRequest.getApellido());
        personal.setGenero(personalRequest.getGenero());
        personal.setF_nacimiento(personalRequest.getF_nacimiento());
        personal.setTelefono(personalRequest.getTelefono());
        personal.setDireccion(personalRequest.getDireccion());
        personal.setCargo(cargoOptional.get());
        personal.setUsuario(usuarioOptional.get());

        Personal personalSaved = personalRepository.save(personal);

        return PersonalMapper.INSTANCE.toPersonalResponse(personalSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Personal> personalOptional = personalRepository.findById(id);

        if(personalOptional.isEmpty()) throw new PersonalNotFoundExcep();

        personalRepository.delete(personalOptional.get());
    }
}
