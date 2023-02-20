package com.dias.pessoa.dataaccess.command.pessoa;

import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);
    }
}
