package com.dias.pessoa.domain.pessoa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    @Test
    @DisplayName("Testa se o getNome esta funcionando corretamente")
    public void testeGetNome(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Vinicius Dias");
        
        assertEquals("Vinicius Dias",pessoa.getNome());
    }

    @Test
    @DisplayName("Testa se o setNome esta funcionando corretamente")
    public void testeSetNome(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Vinicius Dias");
        pessoa.setNome("Giovanna Alves");

        assertEquals("Giovanna Alves",pessoa.getNome());
    }
}