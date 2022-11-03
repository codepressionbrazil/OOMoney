package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.TransacaoDTO;
import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import br.codepressionbrazil.OOMoney.model.entities.Transacao;
import br.codepressionbrazil.OOMoney.model.service.TransacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/oomoney/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<Transacao>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Integer id) {
        if (!transacaoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma transação com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.findById(id));
    }

    @GetMapping("/pessoa/{pessoa}")
    public ResponseEntity<Object> findByPessoa(@PathVariable(name = "pessoa") Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.findByPessoa(pessoa));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        Transacao transacao = new Transacao();
        System.out.println(transacaoDTO.toString());
        BeanUtils.copyProperties(transacaoDTO, transacao);
        System.out.println(transacao.toString());
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.save(transacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid TransacaoDTO transacaoDTO, @PathVariable(name = "id") Integer id) {
        if (!transacaoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma peça com o ID informado");
        }
        Transacao transacao = transacaoService.findById(id).get();
        BeanUtils.copyProperties(transacaoDTO, transacao);
        transacao.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.save(transacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Integer id) {
        if (!transacaoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma transação com o ID informado");
        }
        transacaoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Transação deletada com sucesso");
    }
}
