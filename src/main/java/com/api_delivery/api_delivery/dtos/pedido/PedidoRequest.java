package com.api_delivery.api_delivery.dtos.pedido;

import com.api_delivery.api_delivery.models.Endereco;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PedidoRequest(
        @NotNull
        UUID fkRestaurante,
        @NotNull
        UUID fkUsuario,
        @NotNull
        UUID fkFormaPagamento,
        Endereco endereco,
        UUID fkEndereco
) {}
