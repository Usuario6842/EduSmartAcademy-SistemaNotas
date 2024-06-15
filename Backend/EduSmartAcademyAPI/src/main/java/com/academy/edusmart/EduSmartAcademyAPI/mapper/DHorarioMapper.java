package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DHorarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.DHorario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DHorarioMapper {
    DHorarioMapper INSTANCE = Mappers.getMapper(DHorarioMapper.class);

    @Mapping(source = "horario.gestion", target = "gestion")
    @Mapping(source = "horario.dia", target = "dia")
    @Mapping(source = "aula.id", target = "idAula")
    @Mapping(source = "aula.nombre", target = "aula")
    @Mapping(source = "materia.id", target = "idMateria")
    @Mapping(source = "materia.nombre", target = "materia")
    @Mapping(source = "docente.personal.nombre", target = "docente.nombre")
    @Mapping(source = "docente.personal.apellido", target = "docente.apellido")
    @Mapping(source = "docente.personal.telefono", target = "docente.telefono")
    @Mapping(source = "docente.personal.cargo.nombre", target = "docente.cargo")

    DHorarioResponse toDHorarioResponse(DHorario dHorario);
}
