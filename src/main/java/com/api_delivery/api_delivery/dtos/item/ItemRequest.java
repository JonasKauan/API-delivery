package com.api_delivery.api_delivery.dtos.item;

import com.api_delivery.api_delivery.models.CategoriaItem;
import com.api_delivery.api_delivery.models.Restaurante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ItemRequest(
        @NotNull
        UUID fkRestaurante,
        @NotNull
        UUID fkCategoriaItem,
        @NotBlank
        String nome,
        @NotNull
        Double valor
) {}
