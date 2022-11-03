package br.codepressionbrazil.OOMoney.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ClassificacaoDTO {

    @NotBlank
    private String nomeClassificao;

}
