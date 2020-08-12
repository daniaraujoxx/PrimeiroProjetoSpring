package br.com.rdevs.PrimeiroProjetoSpring.controller;

import br.com.rdevs.PrimeiroProjetoSpring.model.dto.LojaDTO;
import br.com.rdevs.PrimeiroProjetoSpring.model.entity.LojaEntity;
import br.com.rdevs.PrimeiroProjetoSpring.repository.LojaRepository;
import br.com.rdevs.PrimeiroProjetoSpring.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/loja/buscarPorNome/{nome}")
    public ResponseEntity burcarPorNome (@PathParam("nome") String nome){
        return ResponseEntity.ok().body(service.buscarPorNome(nome));
    }

    @PostMapping("/loja")
    public ResponseEntity inserir(@RequestBody LojaDTO lojaDTO){
        service.inserir(lojaDTO);
        return  ResponseEntity.ok().body(lojaDTO);
    }

    @PutMapping("/loja")
    public ResponseEntity atualizar(@RequestBody LojaDTO lojaDTO){
        service.atualizar(lojaDTO);
        return  ResponseEntity.ok().body(lojaDTO);
    }

    @DeleteMapping("/loja")
    public  ResponseEntity deletar(@PathVariable("codigo") Integer codigo){
        return ResponseEntity.ok().body(service.excluir(codigo));
    }
}
