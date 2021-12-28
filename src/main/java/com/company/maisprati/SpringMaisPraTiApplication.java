package com.company.maisprati;

import com.company.maisprati.domain.Aluno;
import com.company.maisprati.domain.Pessoa;
import com.company.maisprati.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class SpringMaisPraTiApplication implements CommandLineRunner{

    @Autowired
    private PessoaRepository pessoaRepository;

    public static void main(String[] args) {

        SpringApplication.run(SpringMaisPraTiApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Aluno aluno = new Aluno(null, "Diego", "51998647487", sdf.parse("05/03/1990"), sdf.parse("28/12/2021 17:00"), null, 8.0);
        Pessoa pessoa = new Pessoa(null, "Michelle", "51998110343", sdf.parse("13/02/1988"), sdf.parse("28/12/2021 17:01"), null);

        pessoaRepository.saveAll(Arrays.asList(aluno,pessoa));

    }


}
