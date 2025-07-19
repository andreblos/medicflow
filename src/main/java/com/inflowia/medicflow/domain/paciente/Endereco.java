package com.inflowia.medicflow.domain.paciente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

/**
 * Representa o endereço de um paciente.
 */

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

}
