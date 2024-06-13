package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.TutorResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Tutor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TutorMapper {

    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    @Mapping(source = "estudiante", target = "estudiante")
    TutorResponse toTutorResponse(Tutor tutor);
}
