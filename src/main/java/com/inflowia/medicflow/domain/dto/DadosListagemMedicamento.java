package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.medicamento.MedicamentoPrescrito;
    
public record DadosListagemMedicamento (
    Long id,
    String nome,
    String doasgem,
    String frequencia,
    String via
){
    public DadosListagemMedicamento(MedicamentoPrescrito m) {
        this(m.getId(), m.getNome(), m.getDosagem(), m.getFrequencia(), m.getVia());
    }
}
