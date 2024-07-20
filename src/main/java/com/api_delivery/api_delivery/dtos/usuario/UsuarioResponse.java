package com.api_delivery.api_delivery.dtos.usuario;

import com.api_delivery.api_delivery.models.Usuario;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UsuarioResponse {
    private final UUID idUsuario;
    private final String nome;
    private final String email;
    private final String celular;

    public UsuarioResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.celular = usuario.getCelular();
    }
}
