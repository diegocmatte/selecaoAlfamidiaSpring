package com.company.maisprati.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.text.MaskFormatter;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nome;

    @JsonFormat(pattern = "(##) ####-####")
    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date ultimaAlteracao;

    public Pessoa(Integer id, String nome, String telefone, Date dataNascimento, Date dataCadastro, Date ultimaAlteracao) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.ultimaAlteracao = ultimaAlteracao;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                " ID = " + id +
                ", Nome = " + nome +
                ", Telefone = " + formatarString(telefone, "(##) ####-####") +
                ", Data de nascimento = " + dataNascimento +
                ", Data de cadastro = " + dataCadastro +
                ", Última alteração no cadastro = " + ultimaAlteracao +
                " }";
    }

    private String formatarString(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if(obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if(id == null){
            if(other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
