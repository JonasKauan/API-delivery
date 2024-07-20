package com.api_delivery.api_delivery.dtos.restaurante;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RestauranteRequest(

        @NotNull
        UUID categoriaRestaurante,
        @NotBlank
        String nome
) {}
