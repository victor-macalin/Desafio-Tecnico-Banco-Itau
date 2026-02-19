package com.dev.victor.itauDesafio.docs;

import com.dev.victor.itauDesafio.dto.TransacaoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "transacoes",
        description = "EndPoints, responsaveis por criar e deletar transacoes")
public interface TransacaoControllerDoc {

    @Operation(summary = "Cria Transacoes",
            description = "Recebe uma transacao valida e adiciona uma lista")

    @ApiResponse(responseCode = "201",
            description = "Transacao ser validada com sucesso")

    @ApiResponse(responseCode = "422",
            description = "Erro de validacao")

    @ApiResponse(responseCode = "400",
            description = "Erro no servidor")

    ResponseEntity<?> adicionar (@RequestBody TransacaoDto transacaoDto);

    @Operation(summary = "Deleta Transacoes",
            description = "Exclui as transacoes armazenadas em memoria")

    @ApiResponse(responseCode = "200",
            description = "Lista deletada com sucesso")

    ResponseEntity<?> deletar ();
}

