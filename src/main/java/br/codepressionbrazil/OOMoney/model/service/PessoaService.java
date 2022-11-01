package br.codepressionbrazil.OOMoney.model.service;

import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import br.codepressionbrazil.OOMoney.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public <S extends Pessoa> S save(S entity) {
        return pessoaRepository.save(entity);
    }

    public Optional<Pessoa> findById(String s) {
        return pessoaRepository.findById(s);
    }

    public Optional<Pessoa> findByEmail(String email) {
        return pessoaRepository.findByEmail(email);
    }

    public boolean existsById(String s) {
        return pessoaRepository.existsById(s);
    }

    public Boolean existsByEmail(String email) {
        return pessoaRepository.existsByEmail(email);
    }

    public void deleteById(String s) {
        pessoaRepository.deleteById(s);
    }
}
