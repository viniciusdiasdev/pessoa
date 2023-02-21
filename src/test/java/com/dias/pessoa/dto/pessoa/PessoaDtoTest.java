package com.dias.pessoa.dto.pessoa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaDtoTest {

    @Test
    @DisplayName("Testa se o getNome esta funcionando corretamente")
    public void testeGetNome(){
        PessoaDto pessoa = new PessoaDto();
        pessoa.setNome("Vinicius Dias");

        assertEquals("Vinicius Dias",pessoa.getNome());
    }

    @Test
    @DisplayName("Testa se o setNome esta funcionando corretamente")
    public void testeSetNome(){
        PessoaDto pessoa = new PessoaDto();
        pessoa.setNome("Vinicius Dias");
        pessoa.setNome("Giovanna Alves");

        assertEquals("Giovanna Alves",pessoa.getNome());
    }

}