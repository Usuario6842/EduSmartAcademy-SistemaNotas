package com.academy.edusmart.EduSmartAcademyAPI.controller;

import com.academy.edusmart.EduSmartAcademyAPI.exceptions.*;
import com.academy.edusmart.EduSmartAcademyAPI.model.dto.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.academy.edusmart.EduSmartAcademyAPI.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AulaNotFoundExcep.class)
    public ErrorResponse handleAulaNotFoundExcep() {
        List<String> detailMessages = List.of("El aula solicitada no fue encontrada en la base de datos");
        return new ErrorResponse(
                AULA_NOT_FOUND.getCode(),
                HttpStatus.NOT_FOUND,
                AULA_NOT_FOUND.getMessage(),
                LocalDateTime.now(),
                detailMessages
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CargoNotFoundExcep.class)
    public ErrorResponse handleCargoNotFoundExcep() {
        List<String> detailMessages = List.of("El Cargo solicitado no fue encontrado en la base de datos");
        return new ErrorResponse(
                CARGO_NOT_FOUND.getCode(),
                HttpStatus.NOT_FOUND,
                CARGO_NOT_FOUND.getMessage(),
                LocalDateTime.now(),
                detailMessages
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MateriaNotFoundExcep.class)
    public ErrorResponse handleMateriaNotFoundExcep() {
        List<String> detailMessages = List.of("La materia solicitada no fue encontrada en la base de datos");
        return new ErrorResponse(
                MATERIA_NOT_FOUND.getCode(),
                HttpStatus.NOT_FOUND,
                MATERIA_NOT_FOUND.getMessage(),
                LocalDateTime.now(),
                detailMessages
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RolNotFoundExcep.class)
    public ErrorResponse handleRolNotFoundExcep() {
        List<String> detailMessages = List.of("El rol solicitado no fue encontrado en la base de datos");
        return new ErrorResponse(
                ROL_NOT_FOUND.getCode(),
                HttpStatus.NOT_FOUND,
                ROL_NOT_FOUND.getMessage(),
                LocalDateTime.now(),
                detailMessages
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioNotFoundExcep.class)
    public ErrorResponse handleUsuarioNotFoundExcep() {
        List<String> detailMessages = List.of("El usuario solicitado no fue encontrado en la base de datos");
        return new ErrorResponse(
                USUARIO_NOT_FOUND.getCode(),
                HttpStatus.NOT_FOUND,
                USUARIO_NOT_FOUND.getMessage(),
                LocalDateTime.now(),
                detailMessages
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return new ErrorResponse(
                INVALID_ERROR.getCode(),
                HttpStatus.BAD_REQUEST,
                INVALID_ERROR.getMessage(),
                LocalDateTime.now(),
                result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList())
        );
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleInternalServerError(
            Exception exception) {
        return new ErrorResponse(
                GENERIC_ERROR.getCode(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                GENERIC_ERROR.getMessage(),
                LocalDateTime.now(),
                Collections.singletonList(exception.getMessage())
        );
    }
}
