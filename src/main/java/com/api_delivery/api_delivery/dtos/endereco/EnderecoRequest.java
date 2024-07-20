package com.api_delivery.api_delivery.dtos.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record EnderecoRequest(
        @NotNull
        UUID fkUsuario,
        @NotBlank
        String apelido,
        @NotBlank
        String rua,
        @NotNull
        Integer numero,
        String complemento
) {}
