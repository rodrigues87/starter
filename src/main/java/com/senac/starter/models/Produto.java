package com.senac.starter.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Produto extends AbstractEntity  {

    private String nome;
    private String dataDeFabricacao;
    private String dataDeVencimento;
    private String marca;
    private double precoCompra;
    private double precoVenda;

    @ManyToOne()
    private Transacao transacao;
}
