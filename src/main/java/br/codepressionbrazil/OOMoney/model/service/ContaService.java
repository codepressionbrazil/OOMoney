package br.codepressionbrazil.OOMoney.model.service;

import br.codepressionbrazil.OOMoney.model.entities.Conta;
import br.codepressionbrazil.OOMoney.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> getAllContas() {
        return contaRepository.findAll();
    }
}
