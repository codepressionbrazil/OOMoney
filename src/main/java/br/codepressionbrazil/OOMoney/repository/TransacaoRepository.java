package br.codepressionbrazil.OOMoney.repository;

import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import br.codepressionbrazil.OOMoney.model.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    public List<Transacao> findByPessoa(Pessoa pessoa);

}
