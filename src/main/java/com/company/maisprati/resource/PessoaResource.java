package com.company.maisprati.resource;


import com.company.maisprati.domain.Aluno;
import com.company.maisprati.domain.Pessoa;
import com.company.maisprati.dto.PessoaNewDTO;
import com.company.maisprati.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private AlunoResource alunoResource;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Pessoa pessoa = pessoaService.buscar(id);
        if(pessoa instanceof Aluno){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("URL errada!");
        } else {
            return ResponseEntity.ok(pessoa);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PessoaNewDTO pessoaNewDTO){
        Pessoa obj = pessoaService.fromDTO(pessoaNewDTO);
        obj = pessoaService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
