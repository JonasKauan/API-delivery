package com.api_delivery.api_delivery.dtos.item;

import com.api_delivery.api_delivery.dtos.categoriaItem.CategoriaItemResponse;
import com.api_delivery.api_delivery.dtos.restaurante.RestauranteResponse;
import com.api_delivery.api_delivery.models.Item;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ItemResponse {
    private final UUID idItem;
    private final String nome;
    private final Double valor;
    private final RestauranteResponse restaurante;
    private final CategoriaItemResponse categoriaItem;

    public ItemResponse(Item item) {
        this.idItem = item.getIdItem();
        this.restaurante = new RestauranteResponse(item.getRestaurante());
        this.categoriaItem = new CategoriaItemResponse(item.getCategoriaItem());
        this.nome = item.getNome();
        this.valor = item.getValor();
    }
}
