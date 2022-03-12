package com.senac.starter.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String nome;
    private String telefone;
    private String telefoneSecundario;
    private String cep;
    private String rua;
    private int numero;
    private String cidade;
    private String dataDeNascimento;
    private String estadoCivil;
    private String estado;
    private String sexo;

    @OneToMany(mappedBy = "dono",fetch = FetchType.LAZY)
    //@JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Animal> animais;

    @OneToMany(mappedBy = "comprador")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Transacao> transacoes;


    public Usuario(String nome) {
        this.nome = nome;
    }
}
