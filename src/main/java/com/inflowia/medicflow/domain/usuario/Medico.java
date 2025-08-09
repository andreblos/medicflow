package com.inflowia.medicflow.domain.usuario;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "meidcos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "usuario_id")

public class Medico extends Usuario  {

    @Column(nullable = false, unique = true)
    private String crm;
    private String especialidade;
    private String instituicaoFormacao;
    private LocalDate dataFormacao;
    private String sexo;
    private String observacoes;


}
