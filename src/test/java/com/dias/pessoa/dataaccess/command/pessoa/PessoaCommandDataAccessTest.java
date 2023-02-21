package com.dias.pessoa.dataaccess.command.pessoa;

import com.dias.pessoa.dataaccess.command.endereco.EnderecoCommandDataAccess;
import com.dias.pessoa.dataaccess.query.pessoa.PessoaQueryDataAccess;
import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.repository.pessoa.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PessoaCommandDataAccessTest {

    @Mock
    PessoaRepository pessoaRepository;
    @Mock
    PessoaQueryDataAccess pessoaQueryDataAccess;
    @Mock
    EnderecoCommandDataAccess enderecoCommandDataAccess;
    @InjectMocks
    PessoaCommandDataAccess pessoaCommandDataAccess;

    @Test
    @DisplayName("Recebe uma pessoaDto e testa se o repository e enderecoCommand foram chamados corretamente")
    public void cadastroPessoaTest(){
        PessoaDto pessoaDto = new PessoaDto();
        List<Endereco> enderecoList = new ArrayList<>();
        pessoaDto.setNome("Vinicius Dias");
        pessoaDto.setDataNascimento("1998-03-27");
        pessoaDto.setEnderecos(enderecoList);

        PessoaDto pessoaCadastrada = this.pessoaCommandDataAccess.cadastrarPessoa(pessoaDto);

        assertEquals("Vinicius Dias", pessoaCadastrada.getNome());
        assertEquals("1998-03-27", pessoaCadastrada.getDataNascimento());
        verify(this.pessoaRepository, times(1)).save(any(Pessoa.class));
        verify(this.enderecoCommandDataAccess, times(1)).saveAll(anyList());
    }

}