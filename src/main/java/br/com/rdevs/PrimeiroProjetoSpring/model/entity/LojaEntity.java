package br.com.rdevs.PrimeiroProjetoSpring.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_loja")
@Data
public class LojaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column
    private String nome;

    @Column
    private String logomarca;

    @Column
    private String cidade;

}