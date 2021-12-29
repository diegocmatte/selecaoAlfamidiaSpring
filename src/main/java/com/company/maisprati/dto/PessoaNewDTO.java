package com.company.maisprati.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    @JsonProperty("nome")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 11, max =11, message = "O tamanho deve ser 11 caracteres")
    @JsonProperty("telefone")
    private String telefone;

    @NotNull(message = "Preenchimento obrigatório")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("data_nascimento")
    private Date dataNascimento;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("data_cadastro")
    private Date dataCadastro;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("data_alteracao")
    private Date dataAlteracao;

}
