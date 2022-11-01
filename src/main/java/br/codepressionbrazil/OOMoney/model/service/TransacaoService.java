package br.codepressionbrazil.OOMoney.model.service;

import br.codepressionbrazil.OOMoney.model.entities.Transacao;
import br.codepressionbrazil.OOMoney.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }

    public <S extends Transacao> S save(S entity) {
        return transacaoRepository.save(entity);
    }

    public Optional<Transacao> findById(Integer integer) {
        return transacaoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return transacaoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        transacaoRepository.deleteById(integer);
    }
}
