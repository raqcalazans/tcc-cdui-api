// src/main/java/com/brasileirao/controller/GameController.java
package com.cdui.brasileirao_api.controller;

import com.cdui.brasileirao_api.dto.GameDTO;
import com.cdui.brasileirao_api.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDTO> getAllGames() {
        return gameService.findAllGames();
    }
}