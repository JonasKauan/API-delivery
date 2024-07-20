package com.api_delivery.api_delivery.dtos.endereco;

import com.api_delivery.api_delivery.dtos.usuario.UsuarioResponse;
import com.api_delivery.api_delivery.models.Endereco;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EnderecoResponse {
    private final UUID idEndereco;
    private final UsuarioResponse usuario;
    private final String apelido;
    private final String rua;
    private final Integer numero;
    private final String complemento;

    public EnderecoResponse(Endereco endereco) {
        this.idEndereco = endereco.getIdEndereco();
        this.usuario = new UsuarioResponse(endereco.getUsuario());
        this.apelido = endereco.getApelido();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
    }
}
