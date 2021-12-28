package com.company.maisprati.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private double notaFinal;

    public Aluno(String nome, String telefone, Date dataNascimento, Date dataCadastro, Date ultimaAlteracao, double notaFinal) {
        super(nome, telefone, dataNascimento, dataCadastro, ultimaAlteracao);
        this.notaFinal = notaFinal;
    }

}
