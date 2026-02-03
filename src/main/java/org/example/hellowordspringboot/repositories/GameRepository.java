package org.example.hellowordspringboot.repositories;

import org.example.hellowordspringboot.entity.Game;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Game.
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas sobre la tabla "games".
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    /**
     * Busca videojuegos filtrando por su plataforma y permite aplicar un orden específico.
     * @param platform Nombre de la plataforma a buscar.
     * @param sort Configuración de ordenación para los resultados.
     * @return Lista de videojuegos que coinciden con la plataforma indicada.
     */
    List<Game> findGamesByPlatform(String platform, Sort sort);

    /**
     * Obtiene una lista con todos los nombres de plataformas registrados, sin duplicados.
     * Utiliza una consulta personalizada en JPQL para seleccionar valores únicos.
     * @return Lista de cadenas de texto con los nombres de las plataformas únicas.
     */
    @Query("SELECT DISTINCT g.platform FROM Game g")
    List<String> findAllPlatforms();
}