package com.dias.pessoa.http;

import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.service.pessoa.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PessoaControllerTest {

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarPessoa() {
        String responseEntityMessage = "Pessoa cadastrada com sucesso";
        String requestBody = "{\"nome\": \"Vinicius Dias\", \"dataNascimento\": \"27/03/1998\", \"enderecos\": [{\\\"logradouro\\\": \\\"Rua Jose da Silva\\\", \\\"cep\\\": \\\"88646852\\\", \\\"numero\\\": \\\"205\\\", \\\"cidade\\\": \\\"Teste\\\", \\\"enderecoPrincipal\\\": false}]}";
        when(pessoaService.cadastrarPessoa(requestBody)).thenReturn(responseEntityMessage);

        ResponseEntity<String> response = pessoaController.createPessoa(requestBody);

        assertEquals(responseEntityMessage, response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(pessoaService, times(1)).cadastrarPessoa(requestBody);
    }

    @Test
    @DisplayName("Deve testar se pessoaService esta sendo chamado e devolvendo um json com o body")
    public void testGetPessoa() {
        Long id = 1L;
        String requestBody = "{\"nome\": \"Vinicius Dias\", \"dataNascimento\": \"27/03/1998\", \"enderecos\": [{\\\"logradouro\\\": \\\"Rua Jose da Silva\\\", \\\"cep\\\": \\\"88646852\\\", \\\"numero\\\": \\\"205\\\", \\\"cidade\\\": \\\"Teste\\\", \\\"enderecoPrincipal\\\": false}]}";
        when(pessoaService.getPessoa(id)).thenReturn(requestBody);

        ResponseEntity<String> response = pessoaController.getPessoa(id);

        assertEquals(requestBody, response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        verify(pessoaService, times(1)).getPessoa(id);
    }

    @Test
    @DisplayName("Criado duas pessoas e deve testar se o getAll devolve a lista com elas")
    public void testGetAllPessoas() {
        List<PessoaDto> todasPessoasCadastradas = new ArrayList<>();
        PessoaDto pessoa1 = new PessoaDto();
        pessoa1.setNome("Vinicius");
        pessoa1.setDataNascimento("27/03/1998");
        pessoa1.setEnderecos(new ArrayList<>());
        PessoaDto pessoa2 = new PessoaDto();
        pessoa2.setNome("Gioanna");
        pessoa2.setDataNascimento("06/06/1998");
        pessoa2.setEnderecos(new ArrayList<>());
        todasPessoasCadastradas.add(pessoa1);
        todasPessoasCadastradas.add(pessoa2);
        when(pessoaService.getAll()).thenReturn(todasPessoasCadastradas);

        ResponseEntity<List<PessoaDto>> response = pessoaController.getAllPessoas();

        assertEquals(todasPessoasCadastradas, response.getBody());
        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        verify(pessoaService, times(1)).getAll();
    }

    @Test
    @DisplayName("Deve testar se o pessoa service esta sendo chamado e devolvendo a mensagem correta")
    public void testDeletePessoa() {
        Long id = 1L;

        ResponseEntity<String> response = pessoaController.deletePessoa(id);

        assertEquals("Deletado com sucesso", response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(pessoaService, times(1)).deleteById(id);
    }

}