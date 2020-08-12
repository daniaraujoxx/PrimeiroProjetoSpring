package br.com.rdevs.PrimeiroProjetoSpring.controller;

import br.com.rdevs.PrimeiroProjetoSpring.model.dto.LojaDTO;
import br.com.rdevs.PrimeiroProjetoSpring.model.dto.ResultData;
import br.com.rdevs.PrimeiroProjetoSpring.model.entity.LojaEntity;
import br.com.rdevs.PrimeiroProjetoSpring.repository.LojaRepository;
import br.com.rdevs.PrimeiroProjetoSpring.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LojaController {

    @Autowired
   private LojaService service;

    @GetMapping("/loja")
    public ResponseEntity listar(){
        return ResponseEntity.ok().body(service.listar());
    }


    @GetMapping("/loja/buscar/{codigo}")
    public ResponseEntity buscar(@PathVariable("codigo") int codigo){
        return ResponseEntity.ok().body(service.buscar(codigo));
    }

    @GetMapping("/loja/buscarPorNome")
    public ResponseEntity burcarPorNome (@RequestParam("nome") String nome){
        System.out.println(nome);
        return ResponseEntity.ok().body(service.buscarPorNome(nome));
    }

    @PostMapping("/loja")
    public ResponseEntity<Object> inserir(@RequestBody LojaDTO lojaDTO){
        ResultData result = null;
        if(lojaDTO.getNome() == null) {
             result = new ResultData(HttpStatus.BAD_REQUEST.value(),"Atributo Nome Invalido");
        }
        else if(lojaDTO.getLogomarca() == null){
            result = new ResultData(HttpStatus.BAD_REQUEST.value(),"Atributo Logomarca Invalido");
        }
        if(result == null) {
            return ResponseEntity.badRequest().body(result);
        }

        try{
            service.inserir(lojaDTO);
            result = new ResultData(HttpStatus.CREATED.value(),"Dados de Loja inseridos com Sucesso!",lojaDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch (Exception e){
            result = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao criar loja " + e.getMessage());
            return  ResponseEntity.badRequest().body(result);
        }

    }

    @PutMapping("/loja")
    public ResponseEntity atualizar(@RequestBody LojaDTO lojaDTO){
        service.atualizar(lojaDTO);
        return  ResponseEntity.ok().body(lojaDTO);
    }

    @DeleteMapping("/loja/{codigo}")
    public  ResponseEntity deletar(@PathVariable("codigo") Integer codigo){
        return ResponseEntity.ok().body(service.excluir(codigo));
    }
}
