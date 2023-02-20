package com.dias.pessoa.dataaccess.query.endereco;

import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.repository.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EnderecoQueryDataAccess {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco findById(Long id){
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
        return getOptionalEndereco(optionalEndereco);
    }

    public Endereco getOptionalEndereco(Optional<Endereco> enderecoOptional){
        if(enderecoOptional.isEmpty()){
            System.out.println("Endereco nao encontrado");
        }
        return enderecoOptional.get();
    }

    public List<Endereco> findAll() {
        List<Endereco> enderecosList = enderecoRepository.findAll();
        return enderecosList;
    }
}