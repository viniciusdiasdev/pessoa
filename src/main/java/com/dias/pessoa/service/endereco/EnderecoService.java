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
    EnderecoQueryDataAccess enderecoQueryDataAccess;


    public List<EnderecoDto> getAll() {
        List<Endereco> enderecoList = enderecoQueryDataAccess.findAll();
        List<EnderecoDto> enderecoDtosList = new ArrayList<>();
        enderecoList.forEach(endereco -> enderecoDtosList.add(EnderecoDomainToEnderecoDto.converte(endereco)));
        return enderecoDtosList;
    }
}
