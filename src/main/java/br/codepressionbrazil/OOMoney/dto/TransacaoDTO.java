package br.codepressionbrazil.OOMoney.dto;

import br.codepressionbrazil.OOMoney.model.entities.Classificacao;
import br.codepressionbrazil.OOMoney.model.entities.Conta;
import br.codepressionbrazil.OOMoney.model.entities.TipoTransacao;
import lombok.Getter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class TransacaoDTO {

    private String descricao;

    @FutureOrPresent
    private Date dataHora;

    @NotNull
    private Double valorTransacao;

    @NotBlank
    private TipoTransacao tipoTransacao;

    @NotNull
    private Conta idConta;

    @NotNull
    private Classificacao classificacao;

}
