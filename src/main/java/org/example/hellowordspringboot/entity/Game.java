package org.example.hellowordspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa un videojuego en la base de datos.
 * Mapea directamente con la tabla "games" y define sus columnas.
 */

@Data
@Entity
@Table(name = "games")
public class Game {
    /**
     * Identificador único del videojuego.
     * Se genera automáticamente mediante una estrategia de identidad en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "platform")
    private String platform;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

}