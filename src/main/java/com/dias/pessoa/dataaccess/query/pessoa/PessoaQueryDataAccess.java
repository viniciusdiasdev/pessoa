package com.dias.pessoa.dataaccess.query.pessoa;

import com.dias.pessoa.dataaccess.query.endereco.EnderecoQueryDataAccess;
import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.repository.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PessoaQueryDataAccess {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    EnderecoQueryDataAccess enderecoQueryDataAccess;

    public Pessoa findById(Long id){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
        return getOptionalPessoa(optionalPessoa);
    }

    public Pessoa getOptionalPessoa(Optional<Pessoa> pessoaEncontrada){
        if(pessoaEncontrada.isEmpty()){
            System.out.println("Nao encontrada");
        }
        return pessoaEncontrada.get();
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList;
    }
}
