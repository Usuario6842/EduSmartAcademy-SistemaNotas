package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DCalificacionResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.DCalificacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DCalificacionMapper {
    DCalificacionMapper INSTANCE = Mappers.getMapper(DCalificacionMapper.class);

    @Mapping(source = "calificacion", target = "detalle")
    @Mapping(source = "calificacion.docente.especialidad", target = "detalle.docente.especialidad")
    @Mapping(source = "calificacion.docente.personal.cargo.nombre", target = "detalle.docente.cargo")
    @Mapping(source = "calificacion.docente.personal.nombre", target = "detalle.docente.nombre")
    @Mapping(source = "calificacion.docente.personal.apellido", target = "detalle.docente.apellido")
    @Mapping(source = "calificacion.docente.personal.telefono", target = "detalle.docente.telefono")

    DCalificacionResponse toDCalificacionResponse(DCalificacion dCalificacion);
}
