package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.PersonalResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Personal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonalMapper {
    PersonalMapper INSTANCE = Mappers.getMapper(PersonalMapper.class);

    @Mapping(source = "cargo", target = "cargo")
    @Mapping(source = "usuario", target = "usuario")
    PersonalResponse toPersonalResponse(Personal personal);
}
