package com.api_delivery.api_delivery.dtos.formaPagamento;

import com.api_delivery.api_delivery.models.FormaPagamento;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FormaPagamentoResponse {
    private final UUID idFormaPagamento;
    private final String descricao;

    public FormaPagamentoResponse(FormaPagamento formaPagamento) {
        this.idFormaPagamento = formaPagamento.getIdFormaPagamento();
        this.descricao = formaPagamento.getDescricao();
    }
}
