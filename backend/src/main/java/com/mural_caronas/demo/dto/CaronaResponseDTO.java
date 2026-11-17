package com.mural_caronas.demo.dto;

import com.mural_caronas.demo.enums.StatusCaronaEnum;

import java.time.LocalDateTime;

public record CaronaResponseDTO(
        Long id,
        String nome,
        String bairroOrigem,
        LocalDateTime horarioSaida,
        Integer vagasDisponiveis,
        StatusCaronaEnum status
        ) {
}
