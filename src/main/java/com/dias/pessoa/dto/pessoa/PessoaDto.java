package com.dias.pessoa.dto.pessoa;
import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.dto.endereco.EnderecoDto;
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

    private List<EnderecoDto> enderecoDtoList;
}
