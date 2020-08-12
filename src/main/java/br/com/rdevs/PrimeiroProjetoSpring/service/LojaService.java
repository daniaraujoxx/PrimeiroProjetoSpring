package br.com.rdevs.PrimeiroProjetoSpring.service;

import br.com.rdevs.PrimeiroProjetoSpring.model.dto.LojaDTO;
import br.com.rdevs.PrimeiroProjetoSpring.model.entity.LojaEntity;
import br.com.rdevs.PrimeiroProjetoSpring.repository.LojaRepository;
import br.com.rdevs.PrimeiroProjetoSpring.service.bo.LojaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LojaService {
    @Autowired
    private LojaRepository repository;

    @Autowired
    private LojaBO bo;

    public List<LojaDTO> listar (){
        List<LojaEntity> lojasEntidade = repository.findAll();
        List<LojaDTO> lojas = new ArrayList<LojaDTO>();
        for (LojaEntity loja: lojasEntidade) {
            LojaDTO lojaDTO = bo.parseTDO(loja);
            lojas.add(lojaDTO);
        }
        return lojas;
    }

    public  LojaDTO buscar (Integer codigo){
        LojaDTO lojaDTO = bo.parseTDO(repository.getOne(codigo));
        return lojaDTO;
    }

    public  List<LojaDTO> buscarPorNome (String nome){
        List<LojaEntity> lojasEntidade = repository.findByNome(nome);
        List<LojaDTO> lojas = new ArrayList<LojaDTO>();
        for (LojaEntity loja: lojasEntidade) {
            LojaDTO lojaDTO = bo.parseTDO(loja);
            lojas.add(lojaDTO);
        }
        return lojas;
    }

    public void inserir (LojaDTO lojaDTO){
        LojaEntity lojaEntity = bo.parseEntity(lojaDTO,null);
        if(lojaEntity.getNome() != null){
            repository.save(lojaEntity);
        }
    }

    public void atualizar(LojaDTO lojaDTO){
        LojaEntity lojaEntity = repository.getOne(lojaDTO.getCodigo());
        if(lojaEntity != null){
            lojaEntity = bo.parseEntity(lojaDTO, lojaEntity);
            repository.save(lojaEntity);
        }
    }

    public LojaDTO excluir(Integer codigo){
        LojaEntity entity = repository.getOne(codigo);
        LojaDTO dto = new LojaDTO();
        if(entity != null){
            dto = bo.parseTDO(entity);
            repository.delete(entity);
        }
        return dto;
    }




}
