package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.MHorarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.MHorario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MHorarioMapper {
    MHorarioMapper INSTANCE = Mappers.getMapper(MHorarioMapper.class);

    MHorarioResponse toMHorarioResponse(MHorario mHorario);
}
