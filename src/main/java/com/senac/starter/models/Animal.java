package com.senac.starter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String dataDeNascimento;
    private String sexo;
    private String especie;
    private String raca;


    @ManyToOne(optional = false)
    @JsonBackReference
    private Usuario dono;

}
