package org.example.hellowordspringboot.exceptions;

/**
 * Excepción de tiempo de ejecución que se lanza cuando se solicita un videojuego
 * mediante un identificador que no existe en el sistema.
 */
public class GameNotFoundException extends RuntimeException {

    /**
     * Crea una nueva instancia de la excepción incluyendo el ID fallido en el mensaje.
     * @param id El identificador del juego que se intentó buscar sin éxito.
     */
    public GameNotFoundException(Integer id) {
        super("No se ha encontrado el videojuego con el ID: " + id);
    }
}