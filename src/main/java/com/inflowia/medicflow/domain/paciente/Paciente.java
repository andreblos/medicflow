package com.inflowia.medicflow.domain.paciente;

import com.inflowia.medicflow.domain.endereco.Endreco;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

/**
 * Entidade que representa os dados de um paciente no sistema MedicFlow.
 */
@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @CPF
    @Column(unique = true)
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "Formato esperado: (99) 99999-9999")
    private String telefone;

    @Email
    private String email;

    @Embedded
    private Endereco endereco;

    private String planoSaude;

}
