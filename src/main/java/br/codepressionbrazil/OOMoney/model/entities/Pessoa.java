package br.codepressionbrazil.OOMoney.model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pessoa {

    @Id
    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String telefone;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String senha;

}
