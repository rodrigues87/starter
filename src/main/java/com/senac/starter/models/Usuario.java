package com.senac.starter.models;

import com.senac.starter.enums.EstadoCivil;
import com.senac.starter.enums.Estado;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

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


    private int idade;
    private boolean casado;

    public Usuario(String nome, int idade, boolean casado) {
        this.nome = nome;
        this.idade = idade;
        this.casado = casado;
    }
}
