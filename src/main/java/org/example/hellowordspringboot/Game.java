package org.example.hellowordspringboot;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "games")
public class Game {
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