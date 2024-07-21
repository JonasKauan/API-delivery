package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.categoriaRestaurante.CategoriaRestauranteResponse;
import com.api_delivery.api_delivery.services.CategoriaRestauranteService;
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
@RequestMapping("/categorias-restaurante")
@RequiredArgsConstructor
public class CategoriaRestauranteController {
    private final CategoriaRestauranteService service;

    @GetMapping
    public ResponseEntity<List<CategoriaRestauranteResponse>> getCategoriasRestaurante() {
        var categorias = service.getCategoriasRestauranteResponse();

        return categorias.isEmpty()
                ? noContent().build()
                : ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaRestauranteResponse> getCategoriaRestaurantePorId(@PathVariable UUID id) {
        return ok(service.getCategoriaRestauranteResponsePorId(id));
    }
}
