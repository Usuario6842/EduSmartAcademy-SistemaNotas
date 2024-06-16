package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MCalificacionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.MCalificacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MCalificacionMapper {
    MCalificacionMapper INSTANCE = Mappers.getMapper(MCalificacionMapper.class);

    @Mapping(source = "materia", target = "materia")
    @Mapping(source = "estudiante", target = "estudiante")
    @Mapping(source = "docente", target = "docente")
    @Mapping(source = "docente.personal.nombre", target = "docente.nombre")
    @Mapping(source = "docente.personal.apellido", target = "docente.apellido")
    @Mapping(source = "docente.personal.telefono", target = "docente.telefono")
    @Mapping(source = "docente.personal.cargo.nombre", target = "docente.cargo")
    MCalificacionResponse toMCalificacionResponse(MCalificacion mCalificacion);
}
