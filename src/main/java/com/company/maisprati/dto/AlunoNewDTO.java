package com.company.maisprati.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoNewDTO extends PessoaNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Preenchimento obrigatório")
    @JsonProperty("nota_final")
    private Double nota;
}
