package com.api_delivery.api_delivery.dtos.categoriaRestaurante;

import com.api_delivery.api_delivery.models.CategoriaRestaurante;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CategoriaRestauranteResponse {
    private final UUID idCategoriaRestaurante;
    private final String nome;

    public CategoriaRestauranteResponse(CategoriaRestaurante categoria) {
        this.idCategoriaRestaurante = categoria.getIdCategoriaRestaurante();
        this.nome = categoria.getNome();
    }
}
