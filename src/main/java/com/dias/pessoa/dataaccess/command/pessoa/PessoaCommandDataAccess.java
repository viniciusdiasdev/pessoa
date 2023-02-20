package com.dias.pessoa.dataaccess.command.pessoa;

import com.dias.pessoa.dataaccess.query.pessoa.PessoaQueryDataAccess;
import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.repository.pessoa.PessoaRepository;
import com.dias.pessoa.service.pessoa.PessoaDomainToPessoaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class PessoaCommandDataAccess {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PessoaQueryDataAccess pessoaQueryDataAccess;

    public PessoaDto cadastrarPessoa(PessoaDto pessoaDto){
        LocalDate dataNascimento = LocalDate.parse(pessoaDto.getDataNascimento());
        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDto.getNome())
                .dataNascimento(dataNascimento)
                .enderecos(pessoaDto.getEnderecos())
                .build();
        pessoaRepository.save(pessoa);
        return pessoaDto;
    }

    public PessoaDto atualizaPessoaById(PessoaDto pessoaDto, Long id){
        LocalDate dataNascimento = LocalDate.parse(pessoaDto.getDataNascimento());
        Pessoa pessoaAtualizada = Pessoa.builder()
                .id(id)
                .nome(pessoaDto.getNome())
                .dataNascimento(dataNascimento)
                .enderecos(pessoaDto.getEnderecos())
                .build();
        pessoaRepository.save(pessoaAtualizada);
        return pessoaDto;
    }

    public void deletePessoaById(Long id) {
        pessoaRepository.deleteById(id);
    }

    public PessoaDto acrescentaEnderecoPessoaById(EnderecoDto enderecoDto, Long id) {
        Pessoa pessoa = pessoaQueryDataAccess.findById(id);
        List<Endereco> enderecosList = pessoa.getEnderecos();
        Endereco endereco = Endereco.builder()
                .logradouro(enderecoDto.getLogradouro())
                .cep(enderecoDto.getCep())
                .numero(enderecoDto.getNumero())
                .cidade(enderecoDto.getCidade())
                .enderecoPrincipal(enderecoDto.getEnderecoPrincipal())
                .build();
        enderecosList.add(endereco);
        pessoaRepository.save(pessoa);
        return PessoaDomainToPessoaDto.converte(pessoa);
    }
}
