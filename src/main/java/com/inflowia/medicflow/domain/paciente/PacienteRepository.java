package com.inflowia.medicflow.domain.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    @Query("SELECT p FROM Paciente p WHERE p.ativo = true")
    List<Paciente> findAllAtivos();

    Page<Paciente> findAllByAtivoTrue(Pageable pageable);
}


