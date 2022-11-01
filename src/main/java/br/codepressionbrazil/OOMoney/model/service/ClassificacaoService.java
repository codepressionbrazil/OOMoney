package br.codepressionbrazil.OOMoney.model.service;

import br.codepressionbrazil.OOMoney.model.entities.Classificacao;
import br.codepressionbrazil.OOMoney.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassificacaoService {
    @Autowired
    ClassificacaoRepository classificacaoRepository;

    public List<Classificacao> findAll() {
        return classificacaoRepository.findAll();
    }

    public <S extends Classificacao> S save(S entity) {
        return classificacaoRepository.save(entity);
    }

    public Optional<Classificacao> findById(Long aLong) {
        return classificacaoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return classificacaoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        classificacaoRepository.deleteById(aLong);
    }
}
