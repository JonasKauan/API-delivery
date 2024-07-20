package com.api_delivery.api_delivery.dtos.categoriaItem;

import com.api_delivery.api_delivery.models.CategoriaItem;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CategoriaItemResponse {
    private final UUID idCategoriaItem;
    private final String nome;

    public CategoriaItemResponse(CategoriaItem categoria) {
        this.idCategoriaItem = categoria.getIdCategoriaItem();
        this.nome = categoria.getNome();
    }
}
