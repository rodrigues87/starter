package com.senac.starter.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Permissao extends AbstractEntity  {

    private String nome;

    @ManyToMany
    private Set<Usuario> usuarios;
}
