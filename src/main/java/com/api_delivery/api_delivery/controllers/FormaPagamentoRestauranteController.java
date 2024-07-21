package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante.FormaPagamentoRestauranteRequest;
import com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante.FormaPagamentoRestauranteResponse;
import com.api_delivery.api_delivery.services.FormaPagamentoRestauranteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/formas-pagamento-restaurante")
@RequiredArgsConstructor
public class FormaPagamentoRestauranteController {
    private final FormaPagamentoRestauranteService service;

    @PostMapping
    public ResponseEntity<FormaPagamentoRestauranteResponse> cadastrar(
        @RequestBody @Valid FormaPagamentoRestauranteRequest dto
    ) {
        return status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamentoRestauranteResponse>> getFormasPagamentoRestaurante() {
        var formasPagamento = service.getFormasPagamentoRestauranteResponse();

        return formasPagamento.isEmpty()
                ? noContent().build()
                : ok(formasPagamento);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoRestauranteResponse> getFormaPagamentoRestaurantePorId(
            @PathVariable UUID id
    ) {
        return ok(service.getFormaPagamentoRestauranteResponsePorId(id));
    }

    @GetMapping("/restaurante/{fkRestaurante}")
    public ResponseEntity<List<FormaPagamentoRestauranteResponse>> getFormasPagamentPorRestaurante(
            @PathVariable UUID fkRestaurante
    ){
        var formasPagamento = service.getFormasPagamentoPorRestaurante(fkRestaurante);

        return formasPagamento.isEmpty()
                ? noContent().build()
                : ok(formasPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamentoRestauranteResponse> alterar(
            @PathVariable UUID id,
            @RequestBody @Valid FormaPagamentoRestauranteRequest dto
    ) {
        return ok(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        service.deletarPorId(id);
        return noContent().build();
    }
}
