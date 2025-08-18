package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.usuario.Perfil;
import com.inflowia.medicflow.domain.usuario.Usuario;

public record DadosDetalhamentoUsuario(
        Long id,
        String login,
        String nome,
        String sobrenome,
        String email,
        String cpf,
        Perfil perfil,
        boolean ativo,
        DadosEndereco endereco
) {
    public DadosDetalhamentoUsuario(Usuario u) {
        this(
            u.getId(),
            u.getLogin(),
            u.getNome(),
            u.getSobrenome(),
            u.getEmail(),
            u.getCpf(),
            u.getPerfil(),
            u.isAtivo(),
            u.getEndereco() == null
                ? null
                : new DadosEndereco(
                    u.getEndereco().getLogradouro(),
                    u.getEndereco().getNumero(),
                    u.getEndereco().getComplemento(),
                    u.getEndereco().getBairro(),
                    u.getEndereco().getCidade(),
                    u.getEndereco().getUf(),
                    u.getEndereco().getCep()
                )
        );
    }
}
