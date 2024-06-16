package com.academy.edusmart.EduSmartAcademyAPI.utils;

public enum ErrorCatalog {
    INVALID_ERROR("ERR_INV_001", "Invalid parameters."),
    AULA_NOT_FOUND("ERR_AUL_002", "Aula not found."),
    CARGO_NOT_FOUND("ERR_CAR_003", "Cargo not found."),
    MATERIA_NOT_FOUND("ERR_MAT_004", "Materia not found."),
    ROL_NOT_FOUND("ERR_ROL_005", "Rol not found."),
    USUARIO_NOT_FOUND("ERR_USR_006", "Usuario not found."),
    PERSONAL_NOT_FOUND("ERR_PRS_007", "Personal not found."),
    ESTUDIANTE_NOT_FOUND("ERR_EST_008", "Estudiante not found."),
    DOCENTE_NOT_FOUND("ERR_DUC_009", "Docente not found."),
    TUTOR_NOT_FOUND("ERR_TUT_010", "Tutor not found."),
    INSCRIPCION_NOT_FOUND("ERR_INS_011", "Registro de Inscripcion not found."),
    MHORARIO_NOT_FOUND("ERR_HOR_012", "Registro de Horario not found."),
    DHORARIO_NOT_FOUND("ERR_HOR_013", "Registro de detalle de horario not found."),
    MCALIFICACION_NOT_FOUND("ERR_NOT_014", "Registro de Calificacion not found."),
    DCALIFICACION_NOT_FOUND("ERR_NOT_015", "Registro de detalle de Calificacion not found."),
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
