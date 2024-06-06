package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.mapper.CargoMapper;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.CargoRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.CargoResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Cargo;
import com.academy.edusmart.EduSmartAcademyAPI.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImp implements CargoService{
    private final CargoRepository cargoRepository;

    public CargoServiceImp(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    @Override
    public List<CargoResponse> findAll() {
        List<Cargo> cargos = cargoRepository.findAll();
        List<CargoResponse> cargoResponse = new ArrayList<>();

        for(Cargo cargo : cargos){
            cargoResponse.add(CargoMapper.INSTANCE.toCargoResponse(cargo));
        }

        return cargoResponse;
    }

    @Override
    public CargoResponse findById(Long id){
        Optional<Cargo> cargoOptional = cargoRepository.findById(id);
        CargoResponse cargoResponse;

        if(cargoOptional.isEmpty()) throw new RuntimeException();

        return CargoMapper.INSTANCE.toCargoResponse(cargoOptional.get());

    }

    @Override
    public CargoResponse create(CargoRequest cargoRequest){
        Cargo cargo = new Cargo();
        cargo.setNombre(cargoRequest.getNombre());
        cargo.setDescripcion(cargoRequest.getDescripcion());
        Cargo cargoSaved = cargoRepository.save(cargo);

        return CargoMapper.INSTANCE.toCargoResponse(cargoSaved);
    }

    @Override
    public CargoResponse update(Long id, CargoRequest cargoRequest) {
        Optional<Cargo> cargoOptional = cargoRepository.findById(id);

        if(cargoOptional.isEmpty()) throw new RuntimeException();

        Cargo cargo = cargoOptional.get();
        cargo.setNombre(cargoRequest.getNombre());
        cargo.setDescripcion(cargoRequest.getDescripcion());
        Cargo cargoSaved = cargoRepository.save(cargo);

        return CargoMapper.INSTANCE.toCargoResponse(cargoSaved);
    }

    @Override
    public void delete(Long id) {
        Optional<Cargo> cargoOptional = cargoRepository.findById(id);

        if(cargoOptional.isEmpty()) throw new RuntimeException();

        cargoRepository.delete(cargoOptional.get());
    }
}
