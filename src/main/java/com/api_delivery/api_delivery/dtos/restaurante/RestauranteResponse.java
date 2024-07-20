package com.api_delivery.api_delivery.dtos.restaurante;

import com.api_delivery.api_delivery.dtos.categoriaRestaurante.CategoriaRestauranteResponse;

import com.api_delivery.api_delivery.models.Restaurante;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class RestauranteResponse {
    private final UUID idRestaurante;
    private final CategoriaRestauranteResponse categoriaRestaurante;
    private final String nome;
    private final LocalDate dataEntradaPlataforma;
    private final Double taxaEntrega;

    public RestauranteResponse(Restaurante restaurante) {
        this.idRestaurante = restaurante.getIdRestaurante();
        this.categoriaRestaurante = new CategoriaRestauranteResponse(restaurante.getCategoriaRestaurante());
        this.nome = restaurante.getNome();
        this.dataEntradaPlataforma = restaurante.getDataEntradaPlataforma();
        this.taxaEntrega = restaurante.getTaxaEntrega();
    }
}
