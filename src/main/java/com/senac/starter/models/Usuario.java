package com.senac.starter.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Usuario extends AbstractEntity  {

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
