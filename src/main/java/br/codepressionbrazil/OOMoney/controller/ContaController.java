package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.ContaDTO;
import br.codepressionbrazil.OOMoney.model.entities.Conta;
import br.codepressionbrazil.OOMoney.model.entities.Transacao;
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
    public ResponseEntity<List<Conta>> getContas() {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.getAllContas());
    }

    @GetMapping("/{idConta}")
    public ResponseEntity<Object> getConta(@PathVariable(name = "idConta") Long idConta) {
        if (!contaService.existsById(idConta)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe uma conta com esse Id");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findById(idConta));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ContaDTO contaDto) {
        Conta conta = new Conta();
        BeanUtils.copyProperties(contaDto, conta);
        return ResponseEntity.status(HttpStatus.OK).body(contaService.save(conta));
    }

    @PutMapping("/{idConta}")
    public ResponseEntity<Object> edit(@RequestBody @Valid ContaDTO contaDTO, @PathVariable(name = "idConta") Long idConta) {
        if (!contaService.existsById(idConta)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma conta com o ID informado");
        }
        Conta conta = contaService.findById(idConta).get();
        BeanUtils.copyProperties(contaDTO, conta);
        conta.setIdConta(idConta);
        return ResponseEntity.status(HttpStatus.OK).body(contaService.save(conta));
    }

    @DeleteMapping("/{idConta}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "idConta") Long idConta) {
        if (!contaService.existsById(idConta)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id não pertence a nenhuma conta!");
        }
        contaService.deleteById(idConta);
        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso!");
    }

}
