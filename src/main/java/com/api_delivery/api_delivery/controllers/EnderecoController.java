package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.endereco.EnderecoRequest;
import com.api_delivery.api_delivery.dtos.endereco.EnderecoResponse;
import com.api_delivery.api_delivery.services.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/enderecos")
@RequiredArgsConstructor
public class EnderecoController {
    private final EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoResponse> cadastrar(@RequestBody @Valid EnderecoRequest dto) {
        return status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> getEnderecos() {
        var enderecos = service.getEnderecosResponse();

        return enderecos.isEmpty()
                ? noContent().build()
                : ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> getEnderecoPorId(@PathVariable UUID id) {
        return ok(service.getEnderecoResponsePorId(id));
    }

    @GetMapping("/enderecos-usuario")
    public ResponseEntity<List<EnderecoResponse>> getEnderecosPorUsuario(@RequestParam UUID fkUsuario) {
        var enderecos = service.getEnderecosResponsePorUsuario(fkUsuario);

        return enderecos.isEmpty()
                ? noContent().build()
                : ok(enderecos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> alterar(
            @PathVariable UUID id,
            @RequestBody @Valid EnderecoRequest dto
    ) {
        return ok(service.alterar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID id) {
        service.deletarPorId(id);
        return noContent().build();
    }
}
