package br.com.rdevs.PrimeiroProjetoSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BemVindoController {
    @GetMapping("/")
    public String bemVindoMenssage(){
        return "Bem vindo seus lindos!";
    }
}
