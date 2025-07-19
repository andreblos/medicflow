package com.inflowia.medicflow.domain.paciente.dto;

import jakarta.validation.constraints.*;

/**
 * DTO com os dados de endereço do paciente.
 */
public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
        String cep
) {}

