package com.inflowia.medicflow.domain.medicamento;

import com.inflowia.medicflow.domain.dto.MedicamentoBaseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoBaseService {

    private final MedicamentoBaseRespository repository;

    public MedicamentoBaseService(MedicamentoBaseRespository repository){
        this.repository = repository;
    }

    public List<MedicamentoBaseDTO> buscaPorDCB(String q){
        return repository.findByDcbContainingIgnoreCase(q)
        .stream()
        .map(MedicamentoBaseDTO::new)
        .toList();
    }
}
