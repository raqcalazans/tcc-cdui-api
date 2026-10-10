package com.cdui.amantesdofutebol.controller;

import com.cdui.amantesdofutebol.dto.FanDTO;
import com.cdui.amantesdofutebol.model.StadiumFrequency;
import com.cdui.amantesdofutebol.service.FanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FanControllerTest {

    @Mock private FanService fanService;
    private FanController controller;

    @BeforeEach
    void setUp() {
        controller = new FanController(fanService);
    }

    @Test
    void createDelegatesToService() {
        FanDTO input = dto();
        when(fanService.create(input)).thenReturn(input);

        assertSame(input, controller.create(input));
        verify(fanService).create(input);
    }

    @Test
    void findAllDelegatesToService() {
        List<FanDTO> fans = List.of(dto());
        when(fanService.findAll()).thenReturn(fans);

        assertSame(fans, controller.findAll());
        verify(fanService).findAll();
    }

    @Test
    void findByIdDelegatesToService() {
        FanDTO fan = dto();
        when(fanService.findById(7L)).thenReturn(fan);

        assertSame(fan, controller.findById(7L));
        verify(fanService).findById(7L);
    }

    @Test
    void updateDelegatesToService() {
        FanDTO input = dto();
        when(fanService.update(7L, input)).thenReturn(input);

        assertSame(input, controller.update(7L, input));
        verify(fanService).update(7L, input);
    }

    @Test
    void deleteDelegatesToService() {
        controller.delete(7L);

        verify(fanService).delete(7L);
    }

    private FanDTO dto() {
        FanDTO dto = new FanDTO();
        dto.setId(7L);
        dto.setName("Ana Silva");
        dto.setEmail("ana@example.com");
        dto.setBirthDate(LocalDate.of(1995, 4, 20));
        dto.setGender("Feminino");
        dto.setFavoriteTeamId("FLA");
        dto.setCity("Rio de Janeiro");
        dto.setState("RJ");
        dto.setCountry("Brasil");
        dto.setStadiumFrequency(StadiumFrequency.AS_VEZES);
        return dto;
    }
}
