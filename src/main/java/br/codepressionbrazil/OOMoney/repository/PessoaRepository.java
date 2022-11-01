package br.codepressionbrazil.OOMoney.repository;

import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    Optional<Pessoa> findByEmail(String email);

    Boolean existsByEmail(String email);


}
