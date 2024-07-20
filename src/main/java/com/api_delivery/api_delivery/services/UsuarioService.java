package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.usuario.AlterarSenhaRequest;
import com.api_delivery.api_delivery.dtos.usuario.UsuarioRequest;
import com.api_delivery.api_delivery.dtos.usuario.UsuarioResponse;
import com.api_delivery.api_delivery.models.Usuario;
import com.api_delivery.api_delivery.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioResponse cadastrar(UsuarioRequest dto) {
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

        var usuario = new Usuario();
        BeanUtils.copyProperties(dto, usuario);
        return new UsuarioResponse(repository.save(usuario));
    }

    public List<UsuarioResponse> getUsuariosResponse() {
        return repository.findAllResponse();
    }

    public UsuarioResponse getUsuarioResponsePorId(UUID id) {
        return new UsuarioResponse(getPorId(id));
    }

    public Usuario getPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Usuário com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }

    public UsuarioResponse alterar(UUID id, UsuarioRequest dto) {
        var usuario = getPorId(id);

        if(!dto.email().equals(usuario.getEmail()) && repository.existsByEmail(dto.email()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O e-mail fornecido já foi cadastrado"
            );

        if(!dto.celular().equals(usuario.getCelular()) && repository.existsByCelular(dto.celular()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "O celular fornecido já foi cadastrado"
            );

        BeanUtils.copyProperties(dto, usuario);
        return new UsuarioResponse(repository.save(usuario));
    }

    public void alterarSenha(UUID id, AlterarSenhaRequest dto) {
        var usuario = getPorId(id);

        if(!usuario.getSenha().equals(dto.senhaAntiga()))
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "A senha antiga está incorreta"
            );

        usuario.setSenha(dto.senhaNova());
        repository.save(usuario);
    }

    public void deletarPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Usuário com o id fornecido não existe"
            );

        repository.deleteById(id);
    }
}
