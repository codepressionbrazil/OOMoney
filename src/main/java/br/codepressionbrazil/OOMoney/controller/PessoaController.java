package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.PessoaDTO;
import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import br.codepressionbrazil.OOMoney.model.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/oomoney/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> findById(@PathVariable(name = "cpf") String cpf) {
        Optional<Pessoa> pessoa = pessoaService.findById(cpf);
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe nenhuma pessoa com este CPF!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoa.get());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PessoaDTO pessoaDTO) {
        if (pessoaService.existsById(pessoaDTO.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este CPF já está cadastrado!");
        }
        if (pessoaService.existsByEmail(pessoaDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este E-mail já está cadastrado!");
        }
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoa));
    }

//    public ResponseEntity<Pessoa> edit() {
//        return ResponseEntity.status(HttpStatus.OK).body();
//    }


    public void deleteById(String s) {
        pessoaService.deleteById(s);
    }
}
