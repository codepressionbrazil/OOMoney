package br.codepressionbrazil.OOMoney.controller;

import br.codepressionbrazil.OOMoney.dto.PessoaDTO;
import br.codepressionbrazil.OOMoney.dto.PessoaDTOLogin;
import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import br.codepressionbrazil.OOMoney.model.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/oomoney/pessoa")
public class PessoaController {

    @Autowired
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

    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid PessoaDTOLogin pessoaDTOLogin) {
        if (pessoaService.existsByEmail(pessoaDTOLogin.getEmail()) && pessoaService.existsBySenha(pessoaDTOLogin.getSenha())) {
            return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findByEmail(pessoaDTOLogin.getEmail()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe nenhuma pessoa com este Email ou senha!");
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

    @PutMapping("/{cpf}")
    public ResponseEntity<Object> edit(@PathVariable(name = "cpf") String cpf, @RequestBody @Valid PessoaDTO pessoaDTO) {
        if (!pessoaService.existsById(cpf)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este CPF não existe!");
        }
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoa));
    }


    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "cpf") String cpf) {
        if (!pessoaService.existsById(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma pessoa com este CPF!");
        }
        pessoaService.deleteById(cpf);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
    }
}
