package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.TransacaoDTO;
import br.codepressionbrazil.OOMoney.model.entities.Transacao;
import br.codepressionbrazil.OOMoney.model.service.TransacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/oomoney/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    public ResponseEntity<List<Transacao>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.findAll());
    }

    public ResponseEntity<Object> save(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        if (transacaoService.existsById(transacaoDTO.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este CPF já está cadastrado!");
        }
        if (transacaoDTO.existsByEmail(transacaoDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este E-mail já está cadastrado!");
        }
        Transacao transacao = new Transacao();
        BeanUtils.copyProperties(transacaoDTO, transacao);
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.save(transacao));
    }

    public Optional<Transacao> findById(Integer integer) {
        return transacaoService.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return transacaoService.existsById(integer);
    }

    public void deleteById(Integer integer) {
        transacaoService.deleteById(integer);
    }
}
