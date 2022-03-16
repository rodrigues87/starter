package com.senac.starter.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @Temporal(TemporalType.DATE)
    private Date dataModificacao;

    @PrePersist
    public void basicPrePersist() {
        this.dataCriacao = new Date();
    }

    @PreUpdate
    public void basicPreUpdate() {
        this.dataModificacao = new Date();

    }
}

