package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.medicamento.MedicamentoBase;

public record MedicamentoBaseDTO(
    Long id,
    String dcb,
    String nomeComercial,
    String principioAtivo,
    String formaFarmaceutica,
    String dosagemPadrao,
    String viaAdministracao
) {
    public MedicamentoBaseDTO(MedicamentoBase m){
        this(m.getId(), m.getDcb(), m.getNomeComercial(), m.getPricipioAtivo(), m.getFormaFarmaceutica(),
        m.getDosagemPadrão(), m.getViaAdministracao());
    }
}
