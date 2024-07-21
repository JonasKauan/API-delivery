package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.entregador.EntregadorRequest;
import com.api_delivery.api_delivery.dtos.entregador.EntregadorResponse;
import com.api_delivery.api_delivery.dtos.usuario.AlterarSenhaRequest;
import com.api_delivery.api_delivery.services.EntregadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/entregadores")
@RequiredArgsConstructor
public class EntregadorController {
    private final EntregadorService service;

    @PostMapping
    public ResponseEntity<EntregadorResponse> cadastrar(@RequestBody @Valid EntregadorRequest dto) {
        return status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<EntregadorResponse>> getEntregadores() {
        var entregadores = service.getEntregadoresResponse();

        return entregadores.isEmpty()
                ? noContent().build()
                : ok(entregadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregadorResponse> getEntregadorPorId(@PathVariable UUID id) {
        return ok(service.getEntregadorResponsePorId(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<EntregadorResponse> alterar(
            @PathVariable UUID id,
            @RequestBody @Valid EntregadorRequest dto
    ) {
        return ok(service.alterar(id, dto));
    }

    @PatchMapping("/alterar-senha/{id}")
    public ResponseEntity<Void> alterarSenha(
            @PathVariable UUID id,
            @RequestBody @Valid AlterarSenhaRequest dto
    ) {
        service.alterarSenha(id, dto);
        return noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        service.deletarPorId(id);
        return noContent().build();
    }
}
