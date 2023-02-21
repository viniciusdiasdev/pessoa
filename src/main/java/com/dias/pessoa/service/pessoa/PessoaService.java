package com.dias.pessoa.service.pessoa;

import com.dias.pessoa.dataaccess.command.pessoa.PessoaCommandDataAccess;
import com.dias.pessoa.dataaccess.query.pessoa.PessoaQueryDataAccess;
import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.service.endereco.EnderecoDomainToEnderecoDto;
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

    public String cadastrarPessoa(String message) {
        PessoaDto pessoaDto = extensaoJsonApp.fromJson(message, PessoaDto.class);
        pessoaCommandDataAccess.cadastrarPessoa(pessoaDto);
        return message;
    }

    public String getPessoa(Long id) {
        Pessoa pessoaById = pessoaQueryDataAccess.findById(id);
        PessoaDto pessoaDto = PessoaDomainToPessoaDto.converte(pessoaById);
        return extensaoJsonApp.toJson(pessoaDto);
    }

    public List<PessoaDto> getAll() {
        List<Pessoa> pessoaList = pessoaQueryDataAccess.findAll();
        List<PessoaDto> pessoaDtoList = new ArrayList<>();
        pessoaList.forEach(pessoa -> pessoaDtoList.add(PessoaDomainToPessoaDto.converte(pessoa)));
        return pessoaDtoList;
    }

    public void deleteById(Long id) {
        pessoaCommandDataAccess.deletePessoaById(id);
    }

    public PessoaDto atualizaPessoa(String message, Long id) {
        PessoaDto pessoaDto = extensaoJsonApp.fromJson(message, PessoaDto.class);
        return pessoaCommandDataAccess.atualizaPessoaById(pessoaDto, id);
    }

    public PessoaDto adicionaEndereco(String message, Long id) {
        EnderecoDto enderecoDto = extensaoJsonApp.fromJson(message, EnderecoDto.class);
        return pessoaCommandDataAccess.acrescentaEnderecoPessoaById(enderecoDto, id);
    }

    public List<EnderecoDto> getAllEnderecosById(Long id) {
        List<Endereco> enderecosList =  pessoaQueryDataAccess.findAllEnderecosById(id);
        List<EnderecoDto> enderecoDtoList = new ArrayList<>();
        enderecosList.forEach(endereco -> enderecoDtoList.add(EnderecoDomainToEnderecoDto.converte(endereco)));
        return enderecoDtoList;
    }
}
