package com.academy.edusmart.EduSmartAcademyAPI.utils;

public enum ErrorCatalog {
    INVALID_ERROR("ERR_INV_001", "Invalid parameters."),
    AULA_NOT_FOUND("ERR_AUL_002", "Aula not found."),
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
