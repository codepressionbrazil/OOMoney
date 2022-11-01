package br.codepressionbrazil.OOMoney.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transacoes")

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

    @Column(nullable = false)
    private Date dataHora;

    @Column(nullable = false)
    private Double valorTransacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTransacao tipoTransacao;

    @ManyToOne
    @JoinColumn(name = "idConta", nullable = false)
    private Conta idConta;

    @ManyToOne
    @JoinColumn(name = "idClassificacao")
    private Classificacao classificacao;

}
