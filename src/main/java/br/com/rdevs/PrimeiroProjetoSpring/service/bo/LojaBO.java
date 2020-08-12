package br.com.rdevs.PrimeiroProjetoSpring.service.bo;

import br.com.rdevs.PrimeiroProjetoSpring.model.dto.LojaDTO;
import br.com.rdevs.PrimeiroProjetoSpring.model.entity.LojaEntity;
import org.springframework.stereotype.Component;


@Component
public class LojaBO {
    public LojaDTO parseTDO(LojaEntity lojaEntity){
        LojaDTO lojaDTO = new LojaDTO();

        if(lojaEntity == null)
            return lojaDTO;

        lojaDTO.setCodigo(lojaEntity.getCodigo());
        lojaDTO.setNome(lojaEntity.getNome());
        lojaDTO.setLogomarca(lojaEntity.getLogomarca());
        lojaDTO.setCidade(lojaEntity.getCidade());

        return lojaDTO;
    }

    public LojaEntity parseEntity(LojaDTO lojaDTO, LojaEntity lojaEntity){
        if(lojaEntity == null)
            lojaEntity =  new LojaEntity();

        if(lojaDTO == null)
            return lojaEntity;


        lojaEntity.setCodigo(lojaDTO.getCodigo());
        lojaEntity.setNome(lojaDTO.getNome());
        lojaEntity.setLogomarca(lojaDTO.getLogomarca());
        lojaEntity.setCidade(lojaDTO.getCidade());

        return lojaEntity;
    }

}
