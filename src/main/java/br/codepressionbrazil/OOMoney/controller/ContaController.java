package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.model.entities.Conta;
import br.codepressionbrazil.OOMoney.model.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oomoney/contas")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getContas(){
        return ResponseEntity.ok(contaService.getAllContas());
    }

    @PostMapping
    public ResponseEntity<Object> registerConta(){
        return null;
    }

}
