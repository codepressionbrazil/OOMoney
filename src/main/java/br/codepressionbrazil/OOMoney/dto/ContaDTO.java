package br.codepressionbrazil.OOMoney.dto;


import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;


@AllArgsConstructor
@Getter
public class ContaDTO {
    @NonNull
    private Pessoa pessoa_cpf;
}
