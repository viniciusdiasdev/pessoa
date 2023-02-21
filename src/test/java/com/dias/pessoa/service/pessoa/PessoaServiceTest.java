package com.dias.pessoa.service.pessoa;

import com.dias.pessoa.dataaccess.command.pessoa.PessoaCommandDataAccess;
import com.dias.pessoa.dataaccess.query.endereco.EnderecoQueryDataAccess;
import com.dias.pessoa.dataaccess.query.pessoa.PessoaQueryDataAccess;
import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.utils.ExtensaoJsonApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    ExtensaoJsonApp extensaoJsonApp;
    @Mock
    PessoaCommandDataAccess pessoaCommandDataAccess;
    @Mock
    EnderecoQueryDataAccess enderecoQueryDataAccess;
    @Mock
    PessoaQueryDataAccess pessoaQueryDataAccess;
    @InjectMocks
    PessoaService pessoaService;

    @Test
    @DisplayName("Recebe uma string Json e testa se os services estao sendo chamados corretamente")
    public void cadastrarPessoaTest(){
        String pessoaJson = "{\"nome\": \"Vinicius Dias\", \"dataNascimento\": \"27/03/1998\", \"enderecos\": [{\\\"logradouro\\\": \\\"Rua Jose da Silva\\\", \\\"cep\\\": \\\"88646852\\\", \\\"numero\\\": \\\"205\\\", \\\"cidade\\\": \\\"Teste\\\", \\\"enderecoPrincipal\\\": false}]}";
        this.pessoaService.cadastrarPessoa(pessoaJson);

        verify(this.extensaoJsonApp, times(1)).fromJson(anyString(), any(Type.class));
        verify(this.pessoaCommandDataAccess, times(1)).cadastrarPessoa(any());
    }

    @Test
    @DisplayName("Verifica se o service esta sendo chamado e devolvendo uma lista nao null")
    public void getAllPessoas(){

        List<PessoaDto> allPessoas = this.pessoaService.getAll();

        assertNotNull(allPessoas);
        verify(this.pessoaQueryDataAccess, times(1)).findAll();
    }

    @Test
    @DisplayName("Verifica se o service esta sendo chamado para o deleteById")
    public void deleteByIdTeste(){

        this.pessoaService.deleteById(any());

        verify(this.pessoaCommandDataAccess, times(1)).deletePessoaById(any());
    }

    @Test
    @DisplayName("Testa se o service ta sendo usado e mockando pessoa para json")
    public void getPessoaByIdTest(){
        String pessoaJsonTeste = "pessoaDto em json";
        Pessoa pessoa = new Pessoa();
        pessoa.setId(Long.valueOf(1));
        pessoa.setNome("Vinicius Dias");
        pessoa.setDataNascimento(LocalDate.of(1998,03, 27));
        pessoa.setEnderecos(new ArrayList<>());

        when(extensaoJsonApp.toJson(any())).thenReturn(pessoaJsonTeste);
        when(pessoaQueryDataAccess.findById(any())).thenReturn(pessoa);
        String pessoaEncontrada = this.pessoaService.getPessoa(Long.valueOf(1));

        assertEquals("pessoaDto em json",pessoaEncontrada);
        verify(this.extensaoJsonApp, times(1)).toJson(any());
    }
}