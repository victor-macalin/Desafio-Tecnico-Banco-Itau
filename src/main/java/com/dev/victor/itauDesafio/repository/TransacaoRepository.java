package com.dev.victor.itauDesafio.repository;


import com.dev.victor.itauDesafio.dto.EstatisticasDto;
import com.dev.victor.itauDesafio.dto.TransacaoDto;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoDto> dadosSalvos = new ArrayList<>();


    //salvar os dados em uma lista
    public List<TransacaoDto> salvarDados(TransacaoDto transacaoDto) {
        dadosSalvos.add(transacaoDto);
        return dadosSalvos;
    }

    //LimparDados
    public void deletarDados() {
        dadosSalvos.clear();
    }


    //gerar estatisticas
    public EstatisticasDto estatisticas(OffsetDateTime limite) {
        if (dadosSalvos.isEmpty()) {
            return new EstatisticasDto(0L, 0.0, 0.0, 0.0, 0.0);
        } else {
            final var summary = dadosSalvos.stream()
                    .filter(transacaoDto -> transacaoDto.dataHora().isAfter(limite) || transacaoDto.dataHora().isEqual(limite))
                    .mapToDouble(transacaoDto -> transacaoDto.valor().doubleValue())
                    .summaryStatistics();
            if (summary.getCount() == 0) {
                return new EstatisticasDto(0L, 0.0, 0.0, 0.0, 0.0);
            } else {
                return new EstatisticasDto(
                        summary.getCount(),
                        summary.getSum(),
                        summary.getAverage(),
                        summary.getMin(),
                        summary.getMax());
            }
        }
    }
}

