package com.dias.pessoa.service.pessoa;

import com.dias.pessoa.dataaccess.command.PessoaCommandDataAccess;
import com.dias.pessoa.dataaccess.query.pessoa.PessoaQueryDataAccess;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.utils.ExtensaoJsonApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    ExtensaoJsonApp extensaoJsonApp;
    @Autowired
    PessoaCommandDataAccess pessoaCommandDataAccess;

    @Autowired
    PessoaQueryDataAccess pessoaQueryDataAccess;

    public PessoaDto cadastrarPessoa(String message) {
        PessoaDto pessoaDto = extensaoJsonApp.fromJson(message, PessoaDto.class);
        return pessoaCommandDataAccess.cadastrarPessoa(pessoaDto);
    }

    public PessoaDto getPessoa(Long id) {
        Pessoa pessoaById = pessoaQueryDataAccess.findById(id);
        return PessoaDomainToPessoaDto.converte(pessoaById);
    }

    public List<PessoaDto> getAll() {
        List<Pessoa> pessoaList = pessoaQueryDataAccess.findAll();
        List<PessoaDto> pessoaDtoList = new ArrayList<>();
        pessoaList.forEach(pessoa -> pessoaDtoList.add(PessoaDomainToPessoaDto.converte(pessoa)));
        return pessoaDtoList;
    }
}
