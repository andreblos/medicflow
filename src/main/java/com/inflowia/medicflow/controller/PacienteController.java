package com.inflowia.medicflow.controller;

import com.inflowia.medicflow.domain.dto.*;
import com.inflowia.medicflow.domain.paciente.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


/**
 * Controller REST responsável por lidar com operações relacionadas a pacientes.
 * Segue os princípios do SOLID, em especial o de responsabilidade única.
 */
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository repository;

    /**
     * Injeção de dependência via construtor.
     * O Spring automaticamente fornece uma instância do repositório.
     */
    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    /**
     * Cadastrar novo paciente.
     */
    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        Paciente novoPaciente = Paciente.builder()
                .nome(dados.nome())
                .cpf(dados.cpf())
                .dataNascimento(dados.dataNascimento())
                .telefone(dados.telefone())
                .email(dados.email())
                .endereco(dados.endereco().toEntity())
                .build();

        repository.save(novoPaciente);
        return ResponseEntity.ok("Paciente cadastrado com sucesso!");
    }

    /**
     * Listar pacientes.
     */
    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(
        @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        
        var pages = repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(pages);
    }

    /**
     * Buscar paciente por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> buscarPorId(@PathVariable Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    /**
     * Atualizar paciente.
     */
    @PutMapping
    public ResponseEntity<String> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        Paciente paciente = repository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.atualizarInformacoes(dados);
        repository.save(paciente);

        return ResponseEntity.ok("Paciente atualizado com sucesso");
    }

    /**
     * Deleção lógica - marca paciente como inativo.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        paciente.setAtivo(false);
        repository.save(paciente);
        
        return ResponseEntity.noContent().build();
    }

    /**
     * Deleção física - exclui permanentemente.
     */
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        repository.delete(paciente);
        return ResponseEntity.noContent().build();
    }
}

