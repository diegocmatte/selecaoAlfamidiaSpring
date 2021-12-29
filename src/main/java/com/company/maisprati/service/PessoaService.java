package com.company.maisprati.service;

import com.company.maisprati.domain.Pessoa;
import com.company.maisprati.dto.PessoaDTO;
import com.company.maisprati.dto.PessoaNewDTO;
import com.company.maisprati.repository.PessoaRepository;
import com.company.maisprati.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa buscar(Integer id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
    }

    public Pessoa fromDTO(PessoaDTO pessoa){
        Date novaDataAlteracaoCadastro = new Date();
        return new Pessoa(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), null, null, novaDataAlteracaoCadastro);
    }

    public Pessoa fromDTO(PessoaNewDTO pessoa){
        return new Pessoa(pessoa.getId(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getDataNascimento(), pessoa.getDataCadastro(), pessoa.getDataAlteracao());
    }

    @Transactional
    public Pessoa insert(Pessoa obj){
        obj.setId(null);
        obj = pessoaRepository.save(obj);
        return obj;
    }
}
