package br.codepressionbrazil.OOMoney.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "transacoes")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    private String descricao;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Timestamp dataHora;

    @Column(nullable = false)
    private Double valorTransacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransacao tipoTransacao;

    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "idClassificacao")
    private Classificacao classificacao;

}
