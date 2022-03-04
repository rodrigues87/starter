package com.senac.starter.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double totalVenda;
    private String data;
    private String formaDePagamento;

    @OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
    private List<Produto> produtos;
}
