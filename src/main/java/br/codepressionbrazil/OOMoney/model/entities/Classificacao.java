package br.codepressionbrazil.OOMoney.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "classificacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Classificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long idClassificacao;

    @Column(nullable = false)
    private String nomeClassificao;
}
