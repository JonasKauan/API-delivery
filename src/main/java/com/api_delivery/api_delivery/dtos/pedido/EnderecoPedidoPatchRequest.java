package com.api_delivery.api_delivery.dtos.pedido;

import com.api_delivery.api_delivery.models.Endereco;

import java.util.UUID;

public record EnderecoPedidoPatchRequest(
        Endereco endereco,
        UUID fkEndereco
) {}
