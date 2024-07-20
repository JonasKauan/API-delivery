package com.api_delivery.api_delivery.dtos.categoriaItem;

import jakarta.validation.constraints.NotBlank;

public record CategoriaItemRequest(
        @NotBlank
        String nome
) {}
