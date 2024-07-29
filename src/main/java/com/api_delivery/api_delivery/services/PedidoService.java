package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.pedido.EnderecoPedidoPatchRequest;
import com.api_delivery.api_delivery.dtos.pedido.PedidoRequest;
import com.api_delivery.api_delivery.dtos.pedido.PedidoResponse;
import com.api_delivery.api_delivery.enums.StatusPedido;
import com.api_delivery.api_delivery.models.Pedido;
import com.api_delivery.api_delivery.repositories.PedidoRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRespository repository;
    private final RestauranteService restauranteService;
    private final UsuarioService usuarioService;
    private final FormaPagamentoRestauranteService formaPagamentoService;
    private final EnderecoService enderecoService;

    public PedidoResponse cadastrar(PedidoRequest dto) {
        if(dto.fkEndereco() == null && dto.endereco() == null)
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "O endereço do pedido não pode ser nulo"
            );

        var pedido = new Pedido(
                formaPagamentoService.getFormaPagamentoRestaurantePorId(dto.fkFormaPagamento()),
                restauranteService.getRestaurantePorId(dto.fkRestaurante())
        );

        pedido.setUsuario(usuarioService.getUsuarioPorId(dto.fkUsuario()));

        var endereco = dto.fkEndereco() != null
                    ? enderecoService.getEnderecoPorId(dto.fkEndereco())
                    : dto.endereco();

        pedido.setEndereco(endereco);

        BeanUtils.copyProperties(dto, pedido);

        return new PedidoResponse(repository.save(pedido));
    }

    public List<PedidoResponse> getPedidosResponse() {
        return repository.findAllResponse();
    }

    public PedidoResponse getPedidoResponsePorId(UUID id) {
        return new PedidoResponse(getPedidoPorId(id));
    }

    public Pedido getPedidoPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "O pedido com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }

    public PedidoResponse alterar(UUID id, PedidoRequest dto) {
        var pedido = getPedidoPorId(id);

        pedido.setRestaurante(restauranteService.getRestaurantePorId(dto.fkRestaurante()));
        pedido.setUsuario(usuarioService.getUsuarioPorId(dto.fkUsuario()));
        pedido.setFormaPagamento(formaPagamentoService.getFormaPagamentoRestaurantePorId(dto.fkFormaPagamento()));

        var endereco = dto.fkEndereco() != null
                ? enderecoService.getEnderecoPorId(dto.fkEndereco())
                : dto.endereco();

        pedido.setEndereco(endereco);

        BeanUtils.copyProperties(dto, pedido);

        return new PedidoResponse(repository.save(pedido));
    }

    public void alterarEndereco(UUID id, EnderecoPedidoPatchRequest dto) {
        var pedido = getPedidoPorId(id);

        if(
                pedido.getStatusPedido() == StatusPedido.A_CAMINHO &&
                        (dto.fkEndereco() != null || dto.endereco() != null)
        )
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Endereço não pode ser alterado porque o pedido já está a caminho"
            );

        var endereco = dto.fkEndereco() != null
                ? enderecoService.getEnderecoPorId(dto.fkEndereco())
                : dto.endereco();

        pedido.setEndereco(endereco);

        repository.save(pedido);
    }

    public void deletarPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "O pedido com o id fornecido não existe"
            );

        repository.deleteById(id);
    }
}
