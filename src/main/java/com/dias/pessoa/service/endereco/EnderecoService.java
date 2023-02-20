package com.dias.pessoa.service.endereco;

import com.dias.pessoa.dataaccess.command.endereco.EnderecoCommandDataAccess;
import com.dias.pessoa.dataaccess.query.endereco.EnderecoQueryDataAccess;
import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
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
    EnderecoCommandDataAccess enderecoCommandDataAccess;

    @Autowired
    EnderecoQueryDataAccess enderecoQueryDataAccess;

    public EnderecoDto cadastrarEndereco(String message) {
        EnderecoDto enderecoDto = extensaoJsonApp.fromJson(message, EnderecoDto.class);
        return enderecoCommandDataAccess.cadastrarEndereco(enderecoDto);
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
