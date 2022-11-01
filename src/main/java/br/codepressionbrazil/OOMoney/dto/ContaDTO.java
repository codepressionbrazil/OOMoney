package br.codepressionbrazil.OOMoney.dto;


import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import lombok.NonNull;

public class ContaDTO {
    @NonNull
    private Long idConta;

    @NonNull
    private Pessoa pessoa_cpf;
}
