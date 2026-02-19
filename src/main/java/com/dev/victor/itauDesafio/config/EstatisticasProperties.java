package com.dev.victor.itauDesafio.config;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties (prefix = "estatistica")
public record EstatisticasProperties (
        @NotNull
        @Min(1)
        Integer tempoTransacao
) {}

