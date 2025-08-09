package com.inflowia.medicflow.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import org.hibernate.validator.constraints.br.CPF;

import com.inflowia.medicflow.domain.paciente.Endereco;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String login;

    @NotBlank
    private String senha;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;

    @Embedded
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Builder.Default
    private boolean ativo = true;
}