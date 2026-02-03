package org.example.hellowordspringboot.controllers;

import org.example.hellowordspringboot.dto.ErrorResponseDTO;
import org.example.hellowordspringboot.exceptions.GameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controlador de asesoramiento global para la gestión centralizada de excepciones.
 * Captura fallos ocurridos en cualquier controlador y redirige a una vista de error amigable.
 */
@ControllerAdvice
public class GameControllerAdvice {

    /**
     * Maneja específicamente los errores cuando no se encuentra un videojuego solicitado.
     * @param ex Excepción personalizada que contiene el mensaje de error.
     * @param model Modelo para pasar la información del DTO a la vista.
     * @return El nombre de la plantilla HTML "error" con un código de estado 404.
     */
    @ExceptionHandler(GameNotFoundException.class)
    public String handleGameNotFound(GameNotFoundException ex, Model model) {
        ErrorResponseDTO errorDTO = new ErrorResponseDTO("No Encontrado", ex.getMessage(), 404);
        model.addAttribute("errorData", errorDTO);
        return "error";
    }

    /**
     * Manejador genérico para capturar cualquier excepción no controlada en el sistema.
     * @param ex La excepción lanzada originalmente.
     * @param model Modelo para la vista.
     * @return La plantilla "error" con un código de estado 500 (Error Interno).
     */
    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model) {
        ErrorResponseDTO errorDTO = new ErrorResponseDTO("Error del Sistema", ex.getMessage(), 500);
        model.addAttribute("errorData", errorDTO);
        return "error";
    }
}