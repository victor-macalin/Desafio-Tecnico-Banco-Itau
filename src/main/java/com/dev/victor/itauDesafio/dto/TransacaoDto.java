package com.dev.victor.itauDesafio.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

public record TransacaoDto(
        @NotNull(message = "O valor é obrigatorio")
        BigDecimal valor,

        @NotNull(message = "Data e Hora são obrigatorios")
        OffsetDateTime dataHora) {
}
