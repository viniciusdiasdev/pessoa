package com.dias.pessoa.dataaccess.command.endereco;

import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.repository.endereco.EnderecoRepository;
import com.dias.pessoa.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EnderecoCommandDataAccess {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;


    public EnderecoDto cadastrarEndereco(EnderecoDto enderecoDto) {

        return enderecoDto;
    }

    public void saveAll(List<Endereco> enderecoList){
        enderecoRepository.saveAll(enderecoList);
    }
}
