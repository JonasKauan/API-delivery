package com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante;

import com.api_delivery.api_delivery.dtos.formaPagamento.FormaPagamentoResponse;
import com.api_delivery.api_delivery.models.FormaPagamentoRestaurante;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FormaPagamentoPedidoResponse {
    private final UUID idFormaPagamentoRestaurante;
    private final Integer percentualDesconto;
    private final String tipoFormaPagamento;
    private final FormaPagamentoResponse formaPagamento;

    public FormaPagamentoPedidoResponse(FormaPagamentoRestaurante formaPagamento) {
        this.idFormaPagamentoRestaurante = formaPagamento.getIdFormaPagamentoRestaurante();
        this.percentualDesconto = formaPagamento.getPercentualDesconto();
        this.tipoFormaPagamento = formaPagamento.getTipoFormaPagamento().getAlias();
        this.formaPagamento = new FormaPagamentoResponse(formaPagamento.getFormaPagamento());
    }
}
