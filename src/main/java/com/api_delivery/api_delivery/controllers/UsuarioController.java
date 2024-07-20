package com.api_delivery.api_delivery.controllers;

import com.api_delivery.api_delivery.dtos.usuario.AlterarSenhaRequest;
import com.api_delivery.api_delivery.dtos.usuario.UsuarioRequest;
import com.api_delivery.api_delivery.dtos.usuario.UsuarioResponse;
import com.api_delivery.api_delivery.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioRequest dto) {
        return status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getUsuarios() {
        var usuarios = service.getUsuariosResponse();

        return usuarios.isEmpty()
                ? noContent().build()
                : ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioPorId(@PathVariable UUID id) {
        return ok(service.getUsuarioResponsePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> alterar(
            @PathVariable UUID id,
            @RequestBody UsuarioRequest dto
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
