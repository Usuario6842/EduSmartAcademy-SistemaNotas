package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.InscripcionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Inscripcion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InscripcionMapper {
    InscripcionMapper INSTANCE = Mappers.getMapper(InscripcionMapper.class);
    @Mapping(source = "aula", target = "aula")
    @Mapping(source = "materia", target = "materia")
    @Mapping(source = "estudiante", target = "estudiante")
    @Mapping(source = "docente", target = "docente")
    @Mapping(source = "docente.personal.nombre", target = "docente.nombre")
    @Mapping(source = "docente.personal.apellido", target = "docente.apellido")
    @Mapping(source = "docente.personal.telefono", target = "docente.telefono")
    @Mapping(source = "docente.personal.cargo.nombre", target = "docente.cargo")

    InscripcionResponse toInscripcionResponse(Inscripcion inscripcion);
}
