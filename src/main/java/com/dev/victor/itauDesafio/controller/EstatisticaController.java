package com.dev.victor.itauDesafio.controller;

import com.dev.victor.itauDesafio.config.EstatisticasProperties;
import com.dev.victor.itauDesafio.repository.EstatisticaRepository;
import com.dev.victor.itauDesafio.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    final EstatisticaRepository estatisticaRepository;
    final EstatisticasProperties estatisticasProperties;
    final TransacaoRepository transacaoRepository;

    public EstatisticaController( EstatisticaRepository estatisticaRepository, EstatisticasProperties estatisticasProperties, TransacaoRepository transacaoRepository) {
        this.estatisticaRepository = estatisticaRepository;
        this.estatisticasProperties = estatisticasProperties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<?> listar (){
        OffsetDateTime horaInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticasProperties.tempoTransacao());
        log.info("Estatisticas dos ultimos {} segundos \n Transações Realizadas {} \n  Soma total das Transações {} \n Média das transações {} \n Menor Transação {} \n Maior Transação {}",
                estatisticasProperties.tempoTransacao(),
                transacaoRepository.estatisticas(horaInicial).count(),
                transacaoRepository.estatisticas(horaInicial).sum(),
                transacaoRepository.estatisticas(horaInicial).avg(),
                transacaoRepository.estatisticas(horaInicial).min(),
                transacaoRepository.estatisticas(horaInicial).max());
        return ResponseEntity.ok(transacaoRepository.estatisticas(horaInicial));
    }
}
