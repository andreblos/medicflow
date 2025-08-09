package com.inflowia.medicflow.domain.medicamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentoBaseRespository extends JpaRepository<MedicamentoBase, Long> {
    List<MedicamentoBase> findByDcbContainingIgnoreCase(String dcb);

}
