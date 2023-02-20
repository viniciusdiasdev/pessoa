package com.dias.pessoa.dto.pessoa;
import com.dias.pessoa.domain.endereco.Endereco;
import lombok.*;

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
