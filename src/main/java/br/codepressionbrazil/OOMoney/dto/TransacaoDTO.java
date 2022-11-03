package br.codepressionbrazil.OOMoney.dto;

import br.codepressionbrazil.OOMoney.model.entities.Classificacao;
import br.codepressionbrazil.OOMoney.model.entities.Pessoa;
import br.codepressionbrazil.OOMoney.model.entities.TipoTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.PastOrPresent;
import java.sql.Timestamp;

@ToString
@Getter
public class TransacaoDTO {

    private String descricao;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @PastOrPresent
    private Timestamp dataHora;

    @NonNull
    private Double valorTransacao;

    @NonNull
    private TipoTransacao tipoTransacao;

    @NonNull
    private Classificacao classificacao;

    @NonNull
    private Pessoa pessoa;
}
