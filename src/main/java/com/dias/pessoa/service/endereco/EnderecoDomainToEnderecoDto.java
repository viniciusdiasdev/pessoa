package com.dias.pessoa.service.endereco;

import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.service.pessoa.PessoaDomainToPessoaDto;

import java.util.ArrayList;
import java.util.List;

public class EnderecoDomainToEnderecoDto {


    public static EnderecoDto converte(Endereco endereco){
        EnderecoDto enderecoDto = EnderecoDto.builder()
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .cidade(endereco.getCidade())
                .logradouro(endereco.getLogradouro())
                .enderecoPrincipal(endereco.getEnderecoPrincipal())
                .build();
        return enderecoDto;
    }
}
