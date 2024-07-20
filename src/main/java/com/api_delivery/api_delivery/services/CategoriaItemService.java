package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.categoriaItem.CategoriaItemResponse;
import com.api_delivery.api_delivery.models.CategoriaItem;
import com.api_delivery.api_delivery.repositories.CategoriaItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaItemService {
    private final CategoriaItemRepository repository;

    public List<CategoriaItemResponse> getCategoriasItemResponse() {
        return repository.findAllResponse();
    }

    public CategoriaItemResponse getCategoriaItemResponsePorId(UUID id) {
        return new CategoriaItemResponse(getCategoriaItemPorId(id));
    }

    public CategoriaItem getCategoriaItemPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Categoria de item com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }
}
