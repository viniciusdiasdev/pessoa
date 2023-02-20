package com.dias.pessoa.service.pessoa;

import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.pessoa.PessoaDto;

public class PessoaDomainToPessoaDto {


    public static PessoaDto converte(Pessoa pessoa){
        PessoaDto pessoaDto = PessoaDto.builder()
                .nome(pessoa.getNome())
                .dataNascimento(String.valueOf(pessoa.getDataNascimento()))
                .enderecos(pessoa.getEnderecos())
                .build();
        return pessoaDto;
    }
}
