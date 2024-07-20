package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.entregador.EntregadorRequest;
import com.api_delivery.api_delivery.dtos.entregador.EntregadorResponse;
import com.api_delivery.api_delivery.dtos.usuario.AlterarSenhaRequest;
import com.api_delivery.api_delivery.models.Entregador;
import com.api_delivery.api_delivery.repositories.EntregadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EntregadorService {
    private final EntregadorRepository repository;

    public EntregadorResponse cadastrar(EntregadorRequest dto) {
        if(repository.existsByEmail(dto.email()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O e-mail fornecido já foi cadastrado"
            );

        if(repository.existsByCelular(dto.celular()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O celular fornecido já foi cadastrado"
            );

        var entregador = new Entregador();
        BeanUtils.copyProperties(dto, entregador);
        return new EntregadorResponse(repository.save(entregador));
    }

    public List<EntregadorResponse> getEntregadoresResponse() {
        return repository.findAllResponse();
    }

    public EntregadorResponse getEntregadorResponsePorId(UUID id) {
        return new EntregadorResponse(getEntregadorPorId(id));
    }

    public Entregador getEntregadorPorId(UUID id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Entregador com o id fornecido não existe"
            );
        }

        return repository.findById(id).get();
    }

    public EntregadorResponse alterar(UUID id, EntregadorRequest dto) {
        var entregador = getEntregadorPorId(id);

        if(!dto.email().equals(entregador.getEmail()) && repository.existsByEmail(dto.email()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O e-mail fornecido já foi cadastrado"
            );

        if(!dto.celular().equals(entregador.getCelular()) && repository.existsByCelular(dto.celular()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O celular fornecido já foi cadastrado"
            );

        BeanUtils.copyProperties(dto, entregador);
        return new EntregadorResponse(repository.save(entregador));
    }

    public void alterarSenha(UUID id, AlterarSenhaRequest dto) {
        var entregador = getEntregadorPorId(id);

        if(!entregador.getSenha().equals(dto.senhaAntiga()))
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "A senha antiga está incorreta"
            );

        entregador.setSenha(dto.senhaNova());
        repository.save(entregador);
    }

    public void deletarPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Entregador com o id fornecido não existe"
            );


        repository.deleteById(id);
    }
}
