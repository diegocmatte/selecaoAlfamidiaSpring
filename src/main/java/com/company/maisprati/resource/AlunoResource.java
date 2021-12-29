package com.company.maisprati.resource;

import com.company.maisprati.domain.Aluno;
import com.company.maisprati.dto.AlunoNewDTO;
import com.company.maisprati.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Aluno aluno = alunoService.buscar(id);
        return ResponseEntity.ok(aluno);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody AlunoNewDTO alunoNewDTO){
        Aluno obj = alunoService.fromDTO(alunoNewDTO);
        obj = alunoService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
