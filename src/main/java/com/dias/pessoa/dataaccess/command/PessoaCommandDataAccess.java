package com.dias.pessoa.dataaccess.command;

import com.dias.pessoa.domain.Pessoa;
import com.dias.pessoa.dto.PessoaDto;
import com.dias.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class PessoaCommandDataAccess {

    @Autowired
    PessoaRepository pessoaRepository;

    public PessoaDto cadastrarPessoa(PessoaDto pessoaDto){

        LocalDate dataNascimento = LocalDate.parse(pessoaDto.getDataNascimento());
        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDto.getNome())
                .dataNascimento(dataNascimento)
                .enderecos(pessoaDto.getEnderecos())
                .build();
        pessoaRepository.save(pessoa);
        return pessoaDto;
    }

}
