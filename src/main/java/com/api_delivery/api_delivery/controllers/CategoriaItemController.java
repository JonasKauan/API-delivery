package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.categoriaItem.CategoriaItemResponse;
import com.api_delivery.api_delivery.services.CategoriaItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/categorias-item")
@RequiredArgsConstructor
public class CategoriaItemController {
    private final CategoriaItemService service;

    @GetMapping
    public ResponseEntity<List<CategoriaItemResponse>> getCategoriasItem() {
        var categorias = service.getCategoriasItemResponse();

        return categorias.isEmpty()
                ? noContent().build()
                : ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaItemResponse> getCategoriaItemPorId(@PathVariable UUID id) {
        return ok(service.getCategoriaItemResponsePorId(id));
    }
}
