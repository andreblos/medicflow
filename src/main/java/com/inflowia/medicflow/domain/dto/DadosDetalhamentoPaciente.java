package com.inflowia.medicflow.domain.dto;

import java.time.LocalDate;

import com.inflowia.medicflow.domain.paciente.Paciente;

public record DadosDetalhamentoPaciente(
    Long id,
    String nome,
    String email,
    String cpf,
    String Telefone,
    LocalDate dataNascimento,
    DadosEndereco endereco
) {
    public DadosDetalhamentoPaciente(Paciente paciente){
        this(
            paciente.getId(),
            paciente.getNome(),
            paciente.getEmail(),
            paciente.getCpf(),
            paciente.getTelefone(),
            paciente.getDataNascimento(),
            new DadosEndereco(paciente.getEndereco())
        );
    }
} 

