package com.cdui.amantesdofutebol.controller;

import com.cdui.amantesdofutebol.dto.FanDTO;
import com.cdui.amantesdofutebol.service.FanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fans")
public class FanController {

    private final FanService fanService;

    public FanController(FanService fanService) {
        this.fanService = fanService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FanDTO create(@Valid @RequestBody FanDTO fanDTO) {
        return fanService.create(fanDTO);
    }

    @GetMapping
    public List<FanDTO> findAll() {
        return fanService.findAll();
    }

    @GetMapping("/{id}")
    public FanDTO findById(@PathVariable Long id) {
        return fanService.findById(id);
    }

    @PutMapping("/{id}")
    public FanDTO update(@PathVariable Long id, @Valid @RequestBody FanDTO fanDTO) {
        return fanService.update(id, fanDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        fanService.delete(id);
    }
}
