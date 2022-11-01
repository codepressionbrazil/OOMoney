package br.codepressionbrazil.OOMoney.repository;

import br.codepressionbrazil.OOMoney.model.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
