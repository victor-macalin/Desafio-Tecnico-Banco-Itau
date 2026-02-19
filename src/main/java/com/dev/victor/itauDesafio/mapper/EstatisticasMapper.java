package com.dev.victor.itauDesafio.mapper;

import com.dev.victor.itauDesafio.dto.EstatisticasDto;
import com.dev.victor.itauDesafio.model.EstatisticaModel;
import org.springframework.stereotype.Component;

@Component
public class EstatisticasMapper {
    public EstatisticaModel toModel (EstatisticasDto estatisticasDto){
        EstatisticaModel estatisticaModel = new EstatisticaModel();
        estatisticaModel.setCount(estatisticasDto.count());
        estatisticaModel.setSum(estatisticasDto.sum());
        estatisticaModel.setAvg(estatisticasDto.avg());
        estatisticaModel.setMin(estatisticasDto.min());
        estatisticaModel.setMax(estatisticasDto.max());
        return estatisticaModel;
    }
    public EstatisticasDto toDto(EstatisticaModel estatisticaModel){
        return new EstatisticasDto(
                estatisticaModel.getCount(),
                estatisticaModel.getSum(),
                estatisticaModel.getAvg(),
                estatisticaModel.getMin(),
                estatisticaModel.getMax());
    }

}
