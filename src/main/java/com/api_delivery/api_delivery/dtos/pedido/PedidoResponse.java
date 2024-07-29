package com.api_delivery.api_delivery.dtos.pedido;

import com.api_delivery.api_delivery.dtos.entregador.EntregadorResponse;
import com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante.FormaPagamentoPedidoResponse;
import com.api_delivery.api_delivery.dtos.restaurante.RestauranteResponse;
import com.api_delivery.api_delivery.dtos.usuario.UsuarioResponse;
import com.api_delivery.api_delivery.models.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoResponse {
    private final UUID idPedido;
    private final Double valor;
    private final LocalDateTime dataHoraRealizado;
    private final LocalDateTime dataHoraConcluido;
    private final String statusPedido;
    private final Integer avaliacaoRestaurante;
    private final Integer avaliacaoEntrega;
    private final Endereco endereco;
    private final RestauranteResponse restaurante;
    private final UsuarioResponse usuario;
    private final FormaPagamentoPedidoResponse formaPagamentoRestaurante;
    private final EntregadorResponse entregador;

    public PedidoResponse(Pedido p) {
        this.idPedido = p.getIdPedido();
        this.valor = p.getValor();
        this.dataHoraRealizado = p.getDataHoraRealizado();
        this.dataHoraConcluido = p.getDataHoraConcluido();
        this.statusPedido = p.getStatusPedido().getAlias();
        this.avaliacaoRestaurante = p.getAvaliacaoRestaurante();
        this.avaliacaoEntrega = p.getAvaliacaoEntrega();
        this.endereco = p.getEndereco();
        this.restaurante = new RestauranteResponse(p.getRestaurante());
        this.usuario = new UsuarioResponse(p.getUsuario());
        this.formaPagamentoRestaurante = new FormaPagamentoPedidoResponse(p.getFormaPagamento());
        this.entregador = p.getEntregador() != null ? new EntregadorResponse(p.getEntregador()) : null;
    }
}
