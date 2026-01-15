package org.example.hellowordspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

interface GameRepository extends JpaRepository<Game, Integer> {

}
