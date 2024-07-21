package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.formaPagamento.FormaPagamentoResponse;
import com.api_delivery.api_delivery.services.FormaPagamentoService;
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
@RequestMapping("/formas-pagamento")
@RequiredArgsConstructor
public class FormaPagamentoController {
    private final FormaPagamentoService service;

    @GetMapping
    public ResponseEntity<List<FormaPagamentoResponse>> getFormasPagamento() {
        var formasPagamento = service.getFormasPagamentoResponse();

        return formasPagamento.isEmpty()
                ? noContent().build()
                : ok(formasPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoResponse> getFormaPagamentoPorId(@PathVariable UUID id) {
        return ok(service.getFormaPagamentoResponsePorId(id));
    }
}
