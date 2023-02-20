package com.dias.pessoa.http;

import com.dias.pessoa.dto.pessoa.PessoaDto;
import com.dias.pessoa.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDto> createPlacar(@RequestBody String message){
        PessoaDto pessoaCadastrada = pessoaService.cadastrarPessoa(message);

        return new ResponseEntity<>(pessoaCadastrada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> getPessoa(@PathVariable Long id){
        PessoaDto pessoaEncontada = pessoaService.getPessoa(id);
        return new ResponseEntity<>(pessoaEncontada, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> getAllPessoas(){
        List<PessoaDto> todasPessoasCadastradas = pessoaService.getAll();
        return new ResponseEntity<>(todasPessoasCadastradas, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePessoa(@PathVariable Long id){
        pessoaService.deleteById(id);
        return new ResponseEntity<>("Deletado com sucesso" ,HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<PessoaDto> updatePlacar(@RequestBody Map<String, Object> placar, @PathVariable Integer id){
//        placarService.updatePlacar(placar, id);
//    }
//

}
