package com.dev.victor.itauDesafio.mapper;

import com.dev.victor.itauDesafio.dto.TransacaoDto;
import com.dev.victor.itauDesafio.model.TransacaoModel;
import org.springframework.stereotype.Component;

@Component
public class TransacoesMapper {
    public TransacaoModel toModel (TransacaoDto transacaoDto) {
        TransacaoModel transacaoModel = new TransacaoModel();
        transacaoModel.setValor(transacaoDto.valor());
        transacaoModel.setDataHora(transacaoDto.dataHora());
        return  transacaoModel;
    }
    public TransacaoDto toDto (TransacaoModel transacaoModel) {
        return new TransacaoDto(
                transacaoModel.getValor(),
                transacaoModel.getDataHora()
        );
    }
}
