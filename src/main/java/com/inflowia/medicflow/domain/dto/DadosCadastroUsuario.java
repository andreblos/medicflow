package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.usuario.Perfil;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;



public record DadosCadastroUsuario( 
        @NotBlank String login,
        @NotBlank @Size(min = 6, max = 100) String senha,
        @NotBlank String nome,
        @Email @NotBlank String email,
        @NotBlank String sobrenome,
        @NotBlank String cpf,
        @NotNull Perfil perfil,
        @Valid DadosEndereco endereco
        ){
        }

