package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.EstudianteResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mapping(source = "usuario", target = "usuario")
    EstudianteResponse toEstudianteResponse(Estudiante estudiante);
}
