package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.ClassificacaoDTO;
import br.codepressionbrazil.OOMoney.model.entities.Classificacao;
import br.codepressionbrazil.OOMoney.model.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oomoney/classificacao")
public class ClassificacaoController {

    @Autowired
    ClassificacaoService classificacaoService;

    @GetMapping
    public ResponseEntity<List<Classificacao>> findAll(){
        return ResponseEntity.ok(classificacaoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ClassificacaoDTO classificacaoDto){
        // Precisa verificar se a classificação já existe na conta.
        return null;
    }

}
