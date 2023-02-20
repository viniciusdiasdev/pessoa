package com.dias.pessoa.http;

import com.dias.pessoa.dto.endereco.EnderecoDto;
import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> getAllEnderecos(){
        List<EnderecoDto> enderecoDtos = enderecoService.getAll();
        return new ResponseEntity<>(enderecoDtos, HttpStatus.FOUND);
    }
}
