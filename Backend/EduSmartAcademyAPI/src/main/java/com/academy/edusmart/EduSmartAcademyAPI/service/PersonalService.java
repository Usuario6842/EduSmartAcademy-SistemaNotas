package com.academy.edusmart.EduSmartAcademyAPI.service;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.request.PersonalRequest;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.PersonalResponse;

import java.util.List;

public interface PersonalService {
    public List<PersonalResponse> findAll();
    public PersonalResponse findById(Long id);
    public List<PersonalResponse> findAllByCargo(Long idCargo);
    public PersonalResponse create(PersonalRequest personalRequest);
    public PersonalResponse update(Long id, PersonalRequest personalRequest);
    public void delete(Long id);

}
