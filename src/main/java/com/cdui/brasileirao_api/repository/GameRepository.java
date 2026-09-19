// src/main/java/com/brasileirao/repository/GameRepository.java
package com.cdui.brasileirao_api.repository;

import com.cdui.brasileirao_api.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    
    @Query("SELECT g FROM Game g " +
           "LEFT JOIN FETCH g.homeTeam " +
           "LEFT JOIN FETCH g.awayTeam " +
           "LEFT JOIN FETCH g.events")
    List<Game> findAllWithTeamsAndEvents();
}