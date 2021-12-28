package com.company.maisprati.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date ultimaAlteracao;

}
