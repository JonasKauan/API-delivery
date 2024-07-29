package com.api_delivery.api_delivery.dtos.itemPedido;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ItemPedidoRequest(
        @NotNull
        UUID fkItem,
        @NotNull
        UUID fkPedido,
        @NotNull
        @Positive
        Integer quantidade
) {}
