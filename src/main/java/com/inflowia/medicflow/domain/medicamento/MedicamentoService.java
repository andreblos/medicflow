package com.inflowia.medicflow.domain.medicamento;

import com.inflowia.medicflow.domain.dto.DadosCadastroMedicamento;
import com.inflowia.medicflow.domain.dto.DadosListagemMedicamento;
import com.inflowia.medicflow.domain.paciente.PacienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicamentoService {
    private final PacienteRepository pacienteRepository;
    private final MedicamentoPrescritoRepository medicamentoRepository;

    public MedicamentoService(PacienteRepository pacienteRepository, MedicamentoPrescritoRepository medicamentoRepository){
        this.pacienteRepository = pacienteRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

@Transactional
public void adicionarMedicamento(Long pacienteId, DadosCadastroMedicamento dados){
    var paciente = pacienteRepository.findById(pacienteId)
    .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

    var medicamento = MedicamentoPrescrito.builder()
        .nome(dados.nome())
        .dosagem(dados.dosagem())
        .frequencia(dados.frequencia())
        .via(dados.Via())
        .paciente(paciente)
        .build();

        paciente.getMedicamentosAtuais().add(medicamento);
        pacienteRepository.save(paciente);
}

public List<DadosListagemMedicamento> listarMedicamentos(Long pacienteId){
    var paciente = pacienteRepository.findById(pacienteId)
    .orElseThrow(() -> new RuntimeException("Paciente não encontrado."));

    return paciente.getMedicamentosAtuais()
        .stream()
        .map(DadosListagemMedicamento::new)
        .toList();
}

@Transactional
public void removerMedicamento(Long medicamentoId){
    medicamentoRepository.deleteById(medicamentoId);
}

}
