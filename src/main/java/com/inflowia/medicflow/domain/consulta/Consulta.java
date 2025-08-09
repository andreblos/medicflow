package com.inflowia.medicflow.domain.consulta;

import com.inflowia.medicflow.domain.paciente.Paciente;
import com.inflowia.medicflow.domain.usuario.Medico;
import com.inflowia.medicflow.domain.medicamento.MedicamentoPrescrito;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataHora;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medico_id")
    private Medico profissional;

    @ManyToOne(optional =  false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private String motivoConsulta;

    @Column(columnDefinition = "TEXT")
    private String anamnese;

    @Column(columnDefinition = "TEXT")
    private String exameFisico;

    @Column(columnDefinition = "TEXT")
    private String diagnostico;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "consulta_id")
    private List<MedicamentoPrescrito> prescricao = new ArrayList<>();

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(columnDefinition = "TEXT")
    private String laudo;

    @Column(columnDefinition = "TEXT")
    private String status;

    @Enumerated(EnumType.STRING)
    private TipoConsulta tipo;
}
