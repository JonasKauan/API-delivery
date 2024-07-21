package com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante;

import com.api_delivery.api_delivery.dtos.formaPagamento.FormaPagamentoResponse;
import com.api_delivery.api_delivery.dtos.restaurante.RestauranteResponse;
import com.api_delivery.api_delivery.models.FormaPagamentoRestaurante;

import lombok.Getter;

import java.util.UUID;

@Getter
public class FormaPagamentoRestauranteResponse {
    private final UUID idFormaPagamentoRestaurante;
    private final Integer percentualDesconto;
    private final FormaPagamentoResponse formaPagamento;
    private final RestauranteResponse restaurante;

    public FormaPagamentoRestauranteResponse(FormaPagamentoRestaurante formaPagamento) {
        this.idFormaPagamentoRestaurante = formaPagamento.getIdFormaPagamentoRestaurante();
        this.percentualDesconto = formaPagamento.getPercentualDesconto();
        this.formaPagamento = new FormaPagamentoResponse(formaPagamento.getFormaPagamento());
        this.restaurante = new RestauranteResponse(formaPagamento.getRestaurante());
    }
}
