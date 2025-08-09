package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.paciente.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * DTO com os dados de endereço do paciente.
 */
public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
        String cep
) {
        public DadosEndereco(Endereco endereco){
        this(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getCep()
                );
        
}

        public Endereco toEntity(){
                return new Endereco(logradouro, numero, complemento, bairro, cidade, uf,cep);
        }

}

