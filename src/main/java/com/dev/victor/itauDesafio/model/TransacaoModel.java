package com.dev.victor.itauDesafio.model;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoModel {

    private BigDecimal valor;
    private OffsetDateTime dataHora;

    }
