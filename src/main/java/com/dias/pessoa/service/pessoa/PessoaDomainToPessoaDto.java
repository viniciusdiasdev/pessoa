package com.dias.pessoa.service.pessoa;

import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.service.endereco.EnderecoDomainToEnderecoDto;

import java.util.ArrayList;
import java.util.List;

public class PessoaDomainToPessoaDto {


    public static PessoaDto converte(Pessoa pessoa){
        PessoaDto pessoaDto = PessoaDto.builder()
                .nome(pessoa.getNome())
                .dataNascimento(String.valueOf(pessoa.getDataNascimento()))
                .enderecos(pessoa.getEnderecos())
                .build();
        return pessoaDto;
    }

    public List<EnderecoDto> converteEnderecos(List<Endereco> enderecoList){
        List<EnderecoDto> enderecoDtoList = new ArrayList<>();
        enderecoList.forEach(endereco -> enderecoDtoList.add(EnderecoDomainToEnderecoDto.converte(endereco)));
        return enderecoDtoList;
    }
}
