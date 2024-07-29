package com.api_delivery.api_delivery.dtos.restaurante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record RestauranteRequest(
        @NotNull
        UUID categoriaRestaurante,
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
        String senha,
        double taxaEntrega
) {}
