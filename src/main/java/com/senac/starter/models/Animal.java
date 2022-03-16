package com.senac.starter.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Animal extends AbstractEntity {

    private String nome;
    private String dataDeNascimento;
    private String sexo;
    private String especie;
    private String raca;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    //@JsonBackReference
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario dono;

}
