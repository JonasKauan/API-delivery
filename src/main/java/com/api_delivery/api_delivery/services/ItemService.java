package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.item.ItemRequest;
import com.api_delivery.api_delivery.dtos.item.ItemResponse;
import com.api_delivery.api_delivery.models.Item;
import com.api_delivery.api_delivery.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;
    private final RestauranteService restauranteService;
    private final CategoriaItemService categoriaItemService;


    public ItemResponse cadastrar(ItemRequest dto) {
        var item = new Item();

        item.setRestaurante(restauranteService.getRestaurantePorId(dto.fkRestaurante()));
        item.setCategoriaItem(categoriaItemService.getCategoriaItemPorId(dto.fkCategoriaItem()));

        BeanUtils.copyProperties(dto, item);

        return new ItemResponse(repository.save(item));
    }

    public List<ItemResponse> getItensResponse() {
        return repository.findAllResponse();
    }

    public ItemResponse getItemResponsePorId(UUID id) {
        return new ItemResponse(getItemPorId(id));
    }

    public Item getItemPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Item com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }

    public ItemResponse alterar(UUID id, ItemRequest dto) {
        var item = getItemPorId(id);

        item.setRestaurante(restauranteService.getRestaurantePorId(dto.fkRestaurante()));
        item.setCategoriaItem(categoriaItemService.getCategoriaItemPorId(dto.fkCategoriaItem()));

        BeanUtils.copyProperties(dto, item);

        return new ItemResponse(repository.save(item));
    }

    public void deletarPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Item com o id fornecido não existe"
            );

        repository.deleteById(id);
    }
}
