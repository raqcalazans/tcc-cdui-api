package com.selecaoglobocom.brasileirao_api.controller;

import com.globo.brasileirao.dto.FanDTO;
import com.globo.brasileirao.model.Fan;
import com.globo.brasileirao.service.FanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fans") // Rota focada no recurso (dados), e não na UI
public class FanController {

    private final FanService fanService;

    // Injeção de dependência via construtor da sua camada de serviço de negócio
    public FanController(FanService fanService) {
        this.fanService = fanService;
    }

    // O iOS envia o formulário preenchido via POST.
    // O Controller recebe o FanDTO puramente focado em dados e manda salvar.
    @PostMapping
    public ResponseEntity<Fan> registerFan(@RequestBody FanDTO fanDTO) {
        
        Fan savedFan = fanService.saveFan(fanDTO); // A lógica de negócio fica isolada no Service
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFan);
    }
    
    /* 
     * Repare na ausência de endpoints como "/ui/registration-screen".
     * O backend CDUI é totalmente "cego" em relação ao design da tela.
     */
}
