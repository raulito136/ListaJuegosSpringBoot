package org.example.hellowordspringboot;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findGamesByPlatform(String platform, Sort sort);
    public List<Game> findGamesByPlatformOrderByYearDesc(String platform);

    @Query("select g from Game g")
    public List<Game> findGames();

//    @Query("select g from Game g where g.id= ?")
    @Query("select g from Game g where g.id= :id")
    public List<Game> findGamesById(@Param("id") Integer id);

    @Query("select distinct g.platform from Game g")
    public List<String> findPlatformGames();

}
