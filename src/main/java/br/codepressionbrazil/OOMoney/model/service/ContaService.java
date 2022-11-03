package br.codepressionbrazil.OOMoney.model.service;

import br.codepressionbrazil.OOMoney.model.entities.Conta;
import br.codepressionbrazil.OOMoney.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }

    public Optional<Conta> findById(Long aLong) {
        return contaRepository.findById(aLong);
    }

    public <S extends Conta> S save(S entity) {
        return contaRepository.save(entity);
    }

    public boolean existsById(Long aLong) {
        return contaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        contaRepository.deleteById(aLong);
    }
}
