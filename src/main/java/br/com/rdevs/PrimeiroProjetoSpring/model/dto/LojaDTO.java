package br.com.rdevs.PrimeiroProjetoSpring.model.dto;

import lombok.Data;

@Data
public class LojaDTO {

    private int codigo;
    private String nome;
    private String logomarca;
    private String cidade;
}
