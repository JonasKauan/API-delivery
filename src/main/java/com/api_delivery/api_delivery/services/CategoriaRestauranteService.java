package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.categoriaRestaurante.CategoriaRestauranteResponse;
import com.api_delivery.api_delivery.models.CategoriaRestaurante;
import com.api_delivery.api_delivery.repositories.CategoriaRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaRestauranteService {
    private final CategoriaRestauranteRepository repository;

    public List<CategoriaRestauranteResponse> getCategoriasRestauranteResponse() {
        return repository.findAllResponse();
    }

    public CategoriaRestauranteResponse getCategoriaRestauranteResponsePorId(UUID id) {
        return new CategoriaRestauranteResponse(getCategoriaRestaurantePorId(id));
    }

    public CategoriaRestaurante getCategoriaRestaurantePorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Categoria de restaurante com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }
}
