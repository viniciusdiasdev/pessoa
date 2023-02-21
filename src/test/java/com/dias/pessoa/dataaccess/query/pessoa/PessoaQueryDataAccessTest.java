package com.dias.pessoa.dataaccess.query.pessoa;

import com.dias.pessoa.domain.pessoa.Pessoa;
import com.dias.pessoa.repository.pessoa.PessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaQueryDataAccessTest {

    @Mock
    PessoaRepository pessoaRepository;

    @InjectMocks
    PessoaQueryDataAccess pessoaQueryDataAccess;

    @Test
    @DisplayName("Verificar se pessoaRepository esta sendo chamado corretamente e devolvendo um optional")
    public void findByIdTest(){
        when(this.pessoaRepository.findById(any())).thenReturn(Optional.of(new Pessoa()));
        Pessoa pessoa = this.pessoaQueryDataAccess.findById(Long.valueOf(1));

        assertNotNull(pessoa);
        verify(this.pessoaRepository, times(1)).findById(any());
    }

    @Test
    @DisplayName("Verificar se pessoaRepository esta sendo chamado corretamente e devolvendo uma lista de pessoas")
    public void findAllPessoasTest(){
        when(this.pessoaRepository.findAll()).thenReturn(new ArrayList<>());
        List<Pessoa> pessoa = this.pessoaQueryDataAccess.findAll();

        assertNotNull(pessoa);
        verify(this.pessoaRepository, times(1)).findAll();
    }
}