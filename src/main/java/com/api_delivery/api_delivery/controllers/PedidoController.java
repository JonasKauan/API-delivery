package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.pedido.PedidoRequest;
import com.api_delivery.api_delivery.dtos.pedido.PedidoResponse;
import com.api_delivery.api_delivery.services.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponse> cadastrar(@RequestBody @Valid PedidoRequest dto) {
        return status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> getPedidos() {
        var pedidos = service.getPedidosResponse();

        return pedidos.isEmpty()
                ? noContent().build()
                : ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> getPedidoPorId(@PathVariable UUID id) {
        return ok(service.getPedidoResponsePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> alterar(
            @PathVariable UUID id,
            @RequestBody @Valid PedidoRequest dto
    ) {
        return ok(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        service.deletarPorId(id);
        return noContent().build();
    }
}
