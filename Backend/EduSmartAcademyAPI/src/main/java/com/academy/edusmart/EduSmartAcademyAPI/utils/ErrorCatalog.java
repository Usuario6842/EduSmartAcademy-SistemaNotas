package com.academy.edusmart.EduSmartAcademyAPI.utils;

public enum ErrorCatalog {
    AULA_NOT_FOUND("ERR_AUL_001", "Aula not found."),
    INVALID_USR("ERR_INV_002", "Invalid parameters."),
    GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
