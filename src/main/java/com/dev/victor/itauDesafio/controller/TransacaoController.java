package com.dev.victor.itauDesafio.controller;

import com.dev.victor.itauDesafio.config.EstatisticasProperties;
import com.dev.victor.itauDesafio.docs.TransacaoControllerDoc;
import com.dev.victor.itauDesafio.dto.TransacaoDto;
import com.dev.victor.itauDesafio.exception.RegraNegocioException;
import com.dev.victor.itauDesafio.repository.TransacaoRepository;
import com.dev.victor.itauDesafio.service.EstatisticaService;
import com.dev.victor.itauDesafio.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController implements TransacaoControllerDoc {

    final TransacaoService transacaoService;
    final TransacaoRepository transacaoRepository;
    final EstatisticasProperties estatisticasProperties;

    public TransacaoController(TransacaoService transacaoService, TransacaoRepository transacaoRepository, EstatisticasProperties estatisticasProperties) {
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
        this.estatisticasProperties = estatisticasProperties;
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody @Valid TransacaoDto transacaoDto) {
        try {
            transacaoService.validarTransacao(transacaoDto);
            transacaoRepository.salvarDados(transacaoDto);
            OffsetDateTime horaInicial = OffsetDateTime.now();
            OffsetDateTime expira = horaInicial.plusSeconds(estatisticasProperties.tempoTransacao());
            log.info("A transacao foi realizada ás {}, valida até ás {} ", horaInicial, expira);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (RegraNegocioException regraNegocioException) {
            log.error("Erro de validação, tente novamente!");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();

        }
    }

    @DeleteMapping
    public ResponseEntity deletar() {
        transacaoRepository.deletarDados();
        log.info("Lista deletada!");
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
