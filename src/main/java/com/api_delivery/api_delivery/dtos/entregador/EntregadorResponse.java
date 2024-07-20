package com.api_delivery.api_delivery.dtos.entregador;

import com.api_delivery.api_delivery.models.Entregador;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EntregadorResponse {
    private final UUID idEntregador;
    private final String nome;
    private final String email;
    private final String senha;
    private final String celular;
    private final String carta;
    private final Double avaliacao;
    private final boolean entregadorNovo;

    public EntregadorResponse(Entregador entregador) {
        this.idEntregador = entregador.getIdEntregador();
        this.nome = entregador.getNome();
        this.email = entregador.getEmail();
        this.senha = entregador.getSenha();
        this.celular = entregador.getCelular();
        this.carta = entregador.getCarta();
        this.avaliacao = entregador.getAvaliacao();
        this.entregadorNovo = avaliacao == 0.;
    }
}
