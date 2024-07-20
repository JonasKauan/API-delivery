package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.item.ItemRequest;
import com.api_delivery.api_delivery.dtos.item.ItemResponse;
import com.api_delivery.api_delivery.services.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;

    @PostMapping
    public ResponseEntity<ItemResponse> cadastrar(@RequestBody @Valid ItemRequest dto) {
        return ok(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getItens() {
        var itens = service.getItensResponse();

        return itens.isEmpty()
                ? noContent().build()
                : ok(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemPorId(@PathVariable UUID id) {
        return ok(service.getItemResponsePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponse> alterar(@PathVariable UUID id, @RequestBody @Valid ItemRequest dto) {
        return ok(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        service.deletarPorId(id);
        return noContent().build();
    }
}
