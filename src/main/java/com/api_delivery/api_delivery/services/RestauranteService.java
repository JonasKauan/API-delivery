package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.restaurante.RestauranteRequest;
import com.api_delivery.api_delivery.dtos.restaurante.RestauranteResponse;
import com.api_delivery.api_delivery.models.Restaurante;
import com.api_delivery.api_delivery.repositories.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestauranteService {
    private final RestauranteRepository repository;
    private final CategoriaRestauranteService categoriaRestauranteService;

    public RestauranteResponse cadastrar(RestauranteRequest dto) {
        var restaurante = new Restaurante();
        var categoria = categoriaRestauranteService.getCategoriaRestaurantePorId(dto.categoriaRestaurante());

        restaurante.setCategoriaRestaurante(categoria);
        BeanUtils.copyProperties(dto, restaurante);

        return new RestauranteResponse(repository.save(restaurante));
    }

    public List<RestauranteResponse> getRestaurantesResponse() {
        return repository.findAllResponse();
    }

    public RestauranteResponse getRestauranteResponsePorId(UUID id) {
        return new RestauranteResponse(getRestaurantePorId(id));
    }

    public Restaurante getRestaurantePorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Restaurante com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }

    public RestauranteResponse alterar(UUID id, RestauranteRequest dto) {
        var restaurante = getRestaurantePorId(id);
        var categoria = categoriaRestauranteService.getCategoriaRestaurantePorId(dto.categoriaRestaurante());

        restaurante.setCategoriaRestaurante(categoria);
        BeanUtils.copyProperties(dto, restaurante);

        return new RestauranteResponse(repository.save(restaurante));
    }

    public void deletarPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Restaurante com o id fornecido não existe"
            );

        repository.deleteById(id);
    }
}
