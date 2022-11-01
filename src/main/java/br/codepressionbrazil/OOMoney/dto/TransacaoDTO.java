package br.codepressionbrazil.OOMoney.dto;

import br.codepressionbrazil.OOMoney.model.entities.Classificacao;
import br.codepressionbrazil.OOMoney.model.entities.Conta;
import br.codepressionbrazil.OOMoney.model.entities.TipoTransacao;
import lombok.Getter;

import java.util.Date;

@Getter
public class TransacaoDTO {

    private String descricao;

    private Date dataHora;

    private Double valorTransacao;

    private TipoTransacao tipoTransacao;

    private Conta idConta;

    private Classificacao classificacao;

}
