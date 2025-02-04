package com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record FormaPagamentoRestauranteRequest(
        @NotNull
        UUID fkFormaPagamento,
        @NotNull
        UUID fkRestaurante,
        int percentualDesconto,
        @NotNull
        @Positive
        Integer tipoFormaPagamento
) {}
