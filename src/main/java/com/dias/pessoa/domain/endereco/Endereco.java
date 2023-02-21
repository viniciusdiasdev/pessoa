package com.dias.pessoa.domain.endereco;

import com.dias.pessoa.domain.pessoa.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logradouro;
    private String cep;
    private String numero;
    private String cidade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "PESSOA_ID")
    private Pessoa pessoa;

    @Column(name = "eh_endereco_principal")
    private Boolean enderecoPrincipal;

}
