package br.codepressionbrazil.OOMoney.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class PessoaDTO {

    @NotNull
    private String cpf;

    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotNull
    private String telefone;

    @NotBlank
    private String usuario;

    @NotNull
    private String senha;

}
