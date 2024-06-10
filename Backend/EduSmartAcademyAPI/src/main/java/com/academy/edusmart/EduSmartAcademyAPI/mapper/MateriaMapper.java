package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MateriaResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Materia;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MateriaMapper {
    MateriaMapper INSTANCE = Mappers.getMapper(MateriaMapper.class);
    MateriaResponse toMateriaResponse(Materia materia);
}
