package com.dias.pessoa.dto;
import com.dias.pessoa.domain.Endereco;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    private String nome;
    private String dataNascimento;
    private List<Endereco> enderecos;
}
