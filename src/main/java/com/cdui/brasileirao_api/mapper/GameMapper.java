// src/main/java/com/brasileirao/mapper/GameMapper.java
package com.cdui.brasileirao_api.mapper;

import com.cdui.brasileirao_api.dto.GameDTO;
import com.cdui.brasileirao_api.dto.GameEventDTO;
import com.cdui.brasileirao_api.dto.TeamDTO;
import com.cdui.brasileirao_api.model.Game;
import com.cdui.brasileirao_api.model.GameEvent;
import com.cdui.brasileirao_api.model.Team;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameMapper {

    public GameDTO toDto(Game game) {
        if (game == null) {
            return null;
        }

        GameDTO dto = new GameDTO();
        dto.setId(game.getId());
        dto.setHomeGoals(game.getHomeGoals());
        dto.setAwayGoals(game.getAwayGoals());
        dto.setGameDateTime(game.getGameDateTime());
        dto.setStadium(game.getStadium());
        dto.setStatus(game.getStatus().name());

        dto.setHomeTeam(toDto(game.getHomeTeam()));
        dto.setAwayTeam(toDto(game.getAwayTeam()));

        if (game.getEvents() != null) {
            List<GameEventDTO> eventDTOs = game.getEvents().stream()
                    .map(eventEntity -> toDto(eventEntity, game))
                    .collect(Collectors.toList());
            dto.setEvents(eventDTOs);
        } else {
            dto.setEvents(Collections.emptyList());
        }

        return dto;
    }

    public List<GameDTO> toDto(List<Game> games) {
        return games.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private GameEventDTO toDto(GameEvent event, Game parentGame) {
        if (event == null) {
            return null;
        }
        GameEventDTO dto = new GameEventDTO();
        dto.setId(event.getId());
        dto.setDescription(event.getDescription());

        Duration duration = Duration.between(parentGame.getGameDateTime(), event.getEventTime());
        long minutes = duration.toMinutes();
        dto.setTimeInGame(String.format("%d'", minutes));

        return dto;
    }
    
    private TeamDTO toDto(Team team) {
        if (team == null) {
            return null;
        }
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setAcronym(team.getAcronym());
        dto.setLogoURL(team.getLogoUrl());
        dto.setDescription(team.getDescription());
        return dto;
    }
}