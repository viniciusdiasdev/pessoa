package com.dias.pessoa.dto.endereco;
import com.dias.pessoa.domain.endereco.Endereco;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;
}
