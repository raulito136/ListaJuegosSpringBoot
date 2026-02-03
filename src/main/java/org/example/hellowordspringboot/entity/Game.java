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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}