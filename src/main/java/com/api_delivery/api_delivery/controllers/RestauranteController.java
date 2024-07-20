package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.restaurante.RestauranteRequest;
import com.api_delivery.api_delivery.dtos.restaurante.RestauranteResponse;
import com.api_delivery.api_delivery.services.RestauranteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {
    private final RestauranteService service;

    @PostMapping
    public ResponseEntity<RestauranteResponse> cadastrar(@RequestBody @Valid RestauranteRequest dto) {
        return status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<RestauranteResponse>> getRestaurantes() {
        var restaurantes = service.getRestaurantesResponse();

        return restaurantes.isEmpty()
                ? noContent().build()
                : ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteResponse> getRestaurantePorId(@PathVariable UUID id) {
        return ok(service.getRestauranteResponsePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestauranteResponse> alterar(
            @PathVariable UUID id,
            @RequestBody @Valid RestauranteRequest dto
    ) {
        return ok(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        service.deletarPorId(id);
        return noContent().build();
    }
}
