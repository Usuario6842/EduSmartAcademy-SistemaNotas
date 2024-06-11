package com.academy.edusmart.EduSmartAcademyAPI.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequest {

    @NotBlank(message = "El campo username no puede estar vacio")
    private String username;

    @NotBlank(message = "El campo password no puede estar vacio")
    private String password;

    @NotNull(message = "El campo id_rol no puede ser nulo")
    private Long id_rol;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String username, String password, Long id_rol) {
        this.username = username;
        this.password = password;
        this.id_rol = id_rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }
}
