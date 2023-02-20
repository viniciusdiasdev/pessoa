package com.dias.pessoa.service.endereco;

import com.dias.pessoa.dataaccess.command.PessoaCommandDataAccess;
import com.dias.pessoa.dataaccess.query.endereco.EnderecoQueryDataAccess;
import com.dias.pessoa.dataaccess.query.pessoa.PessoaQueryDataAccess;
import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.service.pessoa.PessoaDomainToPessoaDto;
import com.dias.pessoa.utils.ExtensaoJsonApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    ExtensaoJsonApp extensaoJsonApp;
    @Autowired
    PessoaCommandDataAccess pessoaCommandDataAccess;

    @Autowired
    EnderecoQueryDataAccess enderecoQueryDataAccess;

    public PessoaDto cadastrarPessoa(String message) {
        PessoaDto pessoaDto = extensaoJsonApp.fromJson(message, PessoaDto.class);
        return pessoaCommandDataAccess.cadastrarPessoa(pessoaDto);
    }

    public EnderecoDto getEnderecoByIdPessoa(Long id) {
        Endereco enderecoById = enderecoQueryDataAccess.findById(id);
        return EnderecoDomainToEnderecoDto.converte(enderecoById);
    }

    public List<EnderecoDto> getAll() {
        List<Endereco> enderecoList = enderecoQueryDataAccess.findAll();
        List<EnderecoDto> enderecoDtosList = new ArrayList<>();
        enderecoList.forEach(endereco -> enderecoDtosList.add(EnderecoDomainToEnderecoDto.converte(endereco)));
        return enderecoDtosList;
    }
}
