package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.paciente.Paciente;

public record DadosListagemPaciente (
      Long id,
      String nome,
      String Telefone,
      String email,
      String cpf
) {
    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(),paciente.getCpf());
    }
}


