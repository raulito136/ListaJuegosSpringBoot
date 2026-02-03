package org.example.hellowordspringboot.services;

import org.example.hellowordspringboot.entity.Game;
import org.example.hellowordspringboot.repositories.GameRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio para los videojuegos.
 * <p>
 * Esta clase sirve como capa intermedia entre el {@link org.example.hellowordspringboot.controllers.WebController}
 * y el {@link org.example.hellowordspringboot.repositories.GameRepository}, asegurando que el acceso
 * a los datos de la tabla "games" sea coherente.
 */
@Service
public class GameService {

    /** Repositorio para la gestión de persistencia de la entidad Game. */
    private final GameRepository gameRepository;

    /**
     * Constructor para la inyección de dependencias del repositorio.
     * * @param nbaRepository Repositorio de videojuegos (etiquetado como nbaRepository en el código actual).
     */
    public GameService(GameRepository nbaRepository) {
        this.gameRepository = nbaRepository;
    }

    /**
     * Recupera el listado completo de videojuegos almacenados en la base de datos.
     * * @return Una lista con todos los objetos {@link Game} disponibles.
     */
    public List<Game> listarTodos() {
        return gameRepository.findAll();
    }

    /**
     * Obtiene los nombres únicos de todas las plataformas presentes en la biblioteca.
     * <p>
     * Este método es utilizado frecuentemente para generar dinámicamente el menú de navegación.
     * * @return Una lista de cadenas de texto con las plataformas únicas.
     */
    public List<String> obtenerPlataformas() {
        return gameRepository.findAllPlatforms();
    }

    /**
     * Guarda o actualiza un videojuego en la base de datos.
     * * @param game Objeto videojuego que contiene los datos a persistir.
     */
    public void guardar(Game game) {
        gameRepository.save(game);
    }

    /**
     * Busca y filtra videojuegos según la plataforma indicada, ordenándolos por su ID.
     * * @param platform Nombre de la plataforma para realizar el filtrado.
     * @return Lista de videojuegos pertenecientes a la plataforma, ordenada por ID de forma ascendente.
     */
    public List<Game> findGamesByPlatform(String platform) {
        return gameRepository.findGamesByPlatform(platform, Sort.by("id"));
    }

    /**
     * Intenta localizar un videojuego mediante su identificador único.
     * * @param id El identificador numérico del juego.
     * @return Un objeto {@link Optional} que contiene el juego si se encuentra, o está vacío si no.
     */
    public Optional<Game> findById(Integer id) {
        return gameRepository.findById(id);
    }
}