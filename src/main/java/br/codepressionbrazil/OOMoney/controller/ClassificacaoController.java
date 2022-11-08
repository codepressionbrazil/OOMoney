package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.ClassificacaoDTO;
import br.codepressionbrazil.OOMoney.model.entities.Classificacao;
import br.codepressionbrazil.OOMoney.model.entities.Transacao;
import br.codepressionbrazil.OOMoney.model.service.ClassificacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/oomoney/classificacao")
public class ClassificacaoController {

    @Autowired
    ClassificacaoService classificacaoService;

    @GetMapping
    public ResponseEntity<List<Classificacao>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.findAll());
    }

    @GetMapping("/{idClassificacao}")
    public Optional<Classificacao> findById(Long idClassificacao) {
        return classificacaoService.findById(idClassificacao);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ClassificacaoDTO classificacaoDto) {
        Classificacao classificacao = new Classificacao();
        BeanUtils.copyProperties(classificacaoDto, classificacao);
        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.save(classificacao));
    }

    @PutMapping("/{idClassificacao}")
    public ResponseEntity<Object> edit(@RequestBody @Valid ClassificacaoDTO classificacaoDTO, @PathVariable(name = "idClassificacao") Long idClassificacao) {
        if (!classificacaoService.existsById(idClassificacao)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma classificação com o ID informado");
        }
        Classificacao classificacao = classificacaoService.findById(idClassificacao).get();
        BeanUtils.copyProperties(classificacaoDTO, classificacao);
        classificacao.setIdClassificacao(idClassificacao);
        return ResponseEntity.status(HttpStatus.OK).body(classificacaoService.save(classificacao));
    }

    @DeleteMapping("/{idClassificacao}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "idClassificacao") Long idClassificacao) {
        if (!classificacaoService.existsById(idClassificacao)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma classificacao com o ID informado");
        }
        classificacaoService.deleteById(idClassificacao);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Classificação deletada com sucesso!");
    }
}
