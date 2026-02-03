package org.example.hellowordspringboot.dto;

/**
 * Clase DTO (Data Transfer Object) para el manejo de respuestas de error.
 * Agrupa la información técnica y descriptiva de un fallo para ser mostrada en el frontend.
 */
public class ErrorResponseDTO {
    private String error;
    private String message;
    private Integer errorCode;

    /**
     * Constructor completo para inicializar un objeto de error.
     * @param error Nombre corto o categoría del error (ej: "No Encontrado").
     * @param message Mensaje detallado que explica la causa del fallo.
     * @param errorCode Código numérico de estado HTTP (ej: 404, 500).
     */
    public ErrorResponseDTO(String error, String message, Integer errorCode) {
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
    }

    /** @return El nombre o tipo de error. */
    public String getError() { return error; }

    /** @param error Establece el tipo de error. */
    public void setError(String error) { this.error = error; }

    /** @return El mensaje descriptivo del error. */
    public String getMessage() { return message; }

    /** @param message Establece el mensaje descriptivo. */
    public void setMessage(String message) { this.message = message; }

    /** @return El código de error asociado. */
    public Integer getErrorCode() { return errorCode; }

    /** @param errorCode Establece el código numérico de error. */
    public void setErrorCode(Integer errorCode) { this.errorCode = errorCode; }
}