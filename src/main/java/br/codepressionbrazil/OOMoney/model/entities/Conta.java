package br.codepressionbrazil.OOMoney.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long idConta;

    @Column
    private Double saldo = 0.0;

    @ManyToOne
    @JoinColumn(name = "cpfPessoa")
    private Pessoa pessoa;

    @OneToMany
    private List<Classificacao> listaClassificacoes;
}
