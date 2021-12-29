package com.company.maisprati.service;

import com.company.maisprati.domain.Aluno;
import com.company.maisprati.dto.AlunoDTO;
import com.company.maisprati.dto.AlunoNewDTO;
import com.company.maisprati.repository.AlunoRepository;
import com.company.maisprati.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno buscar(Integer id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    @Transactional
    public Aluno insert(Aluno obj){
        obj.setId(null);
        obj = alunoRepository.save(obj);
        return obj;
    }

    public Aluno fromDTO(AlunoNewDTO alunoNewDTO){
        return new Aluno(alunoNewDTO.getId(), alunoNewDTO.getNome(), alunoNewDTO.getTelefone(), alunoNewDTO.getDataNascimento(), alunoNewDTO.getDataCadastro(), alunoNewDTO.getDataAlteracao(), alunoNewDTO.getNota());
    }

    public Aluno fromDTO(AlunoDTO alunoDTO){
        Date novaDataAlteracaoCadastro = new Date();
        return new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getTelefone(), null, null, novaDataAlteracaoCadastro, alunoDTO.getNota());
    }

}
