package com.inflowia.medicflow.domain.dto;

import com.inflowia.medicflow.domain.usuario.Usuario;
import com.inflowia.medicflow.domain.usuario.Perfil;

public record DadosListagemUsuario (
    Long id, String login, String nome, String sobrenome, String email, String cpf, Perfil perfil, Boolean ativo
) {
    public DadosListagemUsuario(Usuario u){
        this(u.getId(), u.getLogin(), u.getNome(), u.getSobrenome(), u.getEmail(), u.getCpf(), u.getPerfil(), u.isAtivo());
    
    }

}
