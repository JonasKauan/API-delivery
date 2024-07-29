package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.endereco.EnderecoRequest;
import com.api_delivery.api_delivery.dtos.endereco.EnderecoResponse;
import com.api_delivery.api_delivery.models.EnderecoUsuario;
import com.api_delivery.api_delivery.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository repository;
    private final UsuarioService usuarioService;

    public EnderecoResponse cadastrar(EnderecoRequest dto) {
        var endereco = new EnderecoUsuario();
        endereco.setUsuario(usuarioService.getUsuarioPorId(dto.fkUsuario()));
        BeanUtils.copyProperties(dto, endereco);
        return new EnderecoResponse(repository.save(endereco));
    }

    public List<EnderecoResponse> getEnderecosResponse() {
        return repository.findAllResponse();
    }

    public EnderecoResponse getEnderecoResponsePorId(UUID id) {
        return new EnderecoResponse(getEnderecoPorId(id));
    }

    public EnderecoUsuario getEnderecoPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Restaurante com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }

    public List<EnderecoResponse> getEnderecosResponsePorUsuario(UUID fkUsuario) {
        return repository.findAllResponseByUsuario(usuarioService.getUsuarioPorId(fkUsuario));
    }

    public EnderecoResponse alterar(UUID id, EnderecoRequest dto) {
        var endereco = getEnderecoPorId(id);
        endereco.setUsuario(usuarioService.getUsuarioPorId(dto.fkUsuario()));
        BeanUtils.copyProperties(dto, endereco);
        return new EnderecoResponse(repository.save(endereco));
    }

    public void deletarPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Restaurante com o id fornecido não existe"
            );

        repository.deleteById(id);
    }
}
