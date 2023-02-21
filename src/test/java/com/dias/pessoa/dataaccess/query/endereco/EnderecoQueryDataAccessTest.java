package com.dias.pessoa.dataaccess.query.endereco;

import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.repository.endereco.EnderecoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnderecoQueryDataAccessTest {

    @Mock
    EnderecoRepository enderecoRepository;

    @InjectMocks
    EnderecoQueryDataAccess enderecoQueryDataAccess;

    @Test
    @DisplayName("Testa se esta chamando o findByPessoaId de enderecoRepository e devolve uma lista")
    public void findAllByPersonIdTest(){
        Long id = 1L;
        List<Endereco> enderecoList = new ArrayList<>();
        Endereco endereco = new Endereco();
        enderecoList.add(endereco);
        when(enderecoRepository.findByPessoaId(any())).thenReturn(enderecoList);

        List<Endereco> enderecosListByPessoaId = this.enderecoQueryDataAccess.findAllByPessoaId(id);

        assertNotNull(enderecosListByPessoaId);
        verify(this.enderecoRepository, times(1)).findByPessoaId(any());
    }

    @Test
    @DisplayName("Testa se esta chamando o findAll de enderecoRepository")
    public void findAllTest(){
        this.enderecoQueryDataAccess.findAll();

        verify(this.enderecoRepository, times(1)).findAll();
    }
}