package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.ContaDTO;
import br.codepressionbrazil.OOMoney.model.entities.Conta;
import br.codepressionbrazil.OOMoney.model.service.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> registerConta(@RequestBody @Valid ContaDTO contaDto){

        Optional<Conta> optionalConta = contaService.findById(contaDto.getIdConta());

        if(optionalConta.isEmpty()){
            Conta conta = new Conta();
            BeanUtils.copyProperties(contaDto, conta);
            return ResponseEntity.ok(contaService.save(conta));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Id de conta já existente!");

    }

}
