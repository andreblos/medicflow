package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.usuario.Perfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull Long id,
        String nome,
        String sobrenome,
        @Email String email,
        Perfil perfil,
        Boolean ativo,
        @Valid DadosEndereco endereco
) {}
