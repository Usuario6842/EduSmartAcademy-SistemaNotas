package com.academy.edusmart.EduSmartAcademyAPI.mapper;

import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.UsuarioResponse;
import com.academy.edusmart.EduSmartAcademyAPI.model.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "rol", target = "rol")
    UsuarioResponse toUsuarioResponse(Usuario usuario);

}
