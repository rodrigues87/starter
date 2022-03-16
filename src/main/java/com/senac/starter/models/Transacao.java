package com.senac.starter.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Transacao extends AbstractEntity {

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
