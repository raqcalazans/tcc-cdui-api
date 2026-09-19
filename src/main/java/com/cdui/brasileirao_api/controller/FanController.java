package com.cdui.brasileirao_api.controller;

import com.cdui.brasileirao_api.dto.FanDTO;
import com.cdui.brasileirao_api.model.Fan;
import com.cdui.brasileirao_api.service.FanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fans")
public class FanController {

    private final FanService fanService;

    public FanController(FanService fanService) {
        this.fanService = fanService;
    }

    @PostMapping
    public ResponseEntity<Fan> registerFan(@RequestBody FanDTO fanDTO) {
        
        Fan savedFan = fanService.saveFan(fanDTO);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFan);
    }
}
