package com.dias.pessoa.dataaccess.query;

import com.dias.pessoa.domain.Pessoa;
import com.dias.pessoa.dto.PessoaDto;
import com.dias.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PessoaQueryDataAccess {

    @Autowired
    PessoaRepository pessoaRepository;

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
}
