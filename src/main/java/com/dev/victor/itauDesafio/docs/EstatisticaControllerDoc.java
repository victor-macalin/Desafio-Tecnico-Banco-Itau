package com.dev.victor.itauDesafio.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatisticas",
description = "Retorna as estatisticas das transacoes")
public interface EstatisticaControllerDoc {

    @Operation(summary = "Gera Etatisticas",
            description = "Gera estatisticas das transacoes dos ultimos 60 segundos")

    @ApiResponse(responseCode = "200",
            description = "Estatisticas geradas com sucesso")

    public ResponseEntity<Void> listar ();
}
