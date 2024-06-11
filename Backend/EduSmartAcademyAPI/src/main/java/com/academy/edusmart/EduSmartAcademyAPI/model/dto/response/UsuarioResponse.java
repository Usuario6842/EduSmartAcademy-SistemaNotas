package com.academy.edusmart.EduSmartAcademyAPI.model.dto.response;

public class UsuarioResponse {
    private Long id;
    private String username;
    private String password;
    private RolResponse rol;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String username, String password, RolResponse rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RolResponse getRol() {
        return rol;
    }

    public void setRol(RolResponse rol) {
        this.rol = rol;
    }
}
