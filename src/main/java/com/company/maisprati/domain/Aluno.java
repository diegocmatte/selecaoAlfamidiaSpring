package com.company.maisprati.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("nota_final")
    private double notaFinal;

    public Aluno(Integer id, String nome, String telefone, Date dataNascimento, Date dataCadastro, Date ultimaAlteracao, double notaFinal) {
        super(id, nome, telefone, dataNascimento, dataCadastro, ultimaAlteracao);
        this.notaFinal = notaFinal;
    }

}
