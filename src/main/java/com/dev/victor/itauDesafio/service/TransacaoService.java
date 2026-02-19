package com.dev.victor.itauDesafio.service;

import com.dev.victor.itauDesafio.dto.TransacaoDto;
import com.dev.victor.itauDesafio.exception.RegraNegocioException;
import com.dev.victor.itauDesafio.model.TransacaoModel;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class TransacaoService {

    public void validarTransacao (TransacaoDto transacaoDto) {
        if (transacaoDto.valor().compareTo(BigDecimal.ZERO) < 0) {
            throw new RegraNegocioException("Erro: Isso não é uma transação valida, transações devem ter valor maior do que zero ");
        }
        if (transacaoDto.dataHora().isAfter(OffsetDateTime.now())){
            throw new RegraNegocioException("Erro: A transação deve estar na data anterior ou presente ao dia de hoje.");
        }
        if(transacaoDto.valor() == null){
            throw new RegraNegocioException("O valor não pode estar vazio");
        }

        if(transacaoDto.dataHora() == null){
            throw new RegraNegocioException("O valor não pode estar vazio");
        }

    }
}
