package org.example.hellowordspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase DTO (Data Transfer Object) para el manejo de respuestas de error.
 * Agrupa la información técnica y descriptiva de un fallo para ser mostrada en el frontend.
 */
@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String error;
    private String message;
    private Integer errorCode;

}