package br.codepressionbrazil.OOMoney.dto;

import br.codepressionbrazil.OOMoney.model.entities.Conta;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
public class ClassificacaoDTO {
    @NonNull
    private Long idClassificacao;
    @NotBlank
    private String nomeClassificao;
    @NonNull
    private Conta idConta;
}
