package com.dias.pessoa.service;

import com.dias.pessoa.domain.Endereco;
import com.dias.pessoa.domain.Pessoa;
import com.dias.pessoa.dto.PessoaDto;

import java.util.List;

public class PessoaToPessoaDto {


    public static PessoaDto converte(Pessoa pessoa){
        PessoaDto pessoaDto = PessoaDto.builder()
                .nome(pessoa.getNome())
                .dataNascimento(String.valueOf(pessoa.getDataNascimento()))
                .enderecos(pessoa.getEnderecos())
                .build();
        return pessoaDto;
    }
}
