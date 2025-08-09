package com.inflowia.medicflow.domain.medicamento;

import com.inflowia.medicflow.domain.paciente.Paciente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class MedicamentoPrescrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dosagem;
    private String frequencia;
    private String via;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Paciente_id")
    private Paciente paciente;

}
