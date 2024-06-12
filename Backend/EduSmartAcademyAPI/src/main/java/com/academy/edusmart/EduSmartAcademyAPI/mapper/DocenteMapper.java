package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.DocenteResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Docente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocenteMapper {
    DocenteMapper INSTANCE = Mappers.getMapper(DocenteMapper.class);

    @Mapping(source = "personal", target = "personal")
    DocenteResponse toDocenteResponse(Docente docente);
}
