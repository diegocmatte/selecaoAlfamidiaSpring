package com.company.maisprati.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
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

    @JsonProperty("nome")
    private String nome;

    @Column(unique = true)
    @JsonProperty("telefone")
    private String telefone;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("data_nascimento")
    private Date dataNascimento;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("data_cadastro")
    private Date dataCadastro;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("data_alteracao")
    private Date ultimaAlteracao;
}
