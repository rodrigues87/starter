package com.senac.starter.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Transacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double totalVenda;
    private String data;
    private String formaDePagamento;

    @OneToMany(mappedBy = "transacao", fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @ManyToOne()
    private Usuario comprador;

    @ManyToOne()
    private Usuario vendedor;
    
    
}