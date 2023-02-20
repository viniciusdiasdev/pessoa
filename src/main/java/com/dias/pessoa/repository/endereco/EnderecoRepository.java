package com.dias.pessoa.repository.endereco;

import com.dias.pessoa.domain.endereco.Endereco;
import com.dias.pessoa.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
