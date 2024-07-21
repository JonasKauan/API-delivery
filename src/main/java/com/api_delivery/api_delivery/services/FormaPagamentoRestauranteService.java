package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante.FormaPagamentoRestauranteRequest;
import com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante.FormaPagamentoRestauranteResponse;
import com.api_delivery.api_delivery.models.FormaPagamentoRestaurante;
import com.api_delivery.api_delivery.repositories.FormaPagamentoRestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FormaPagamentoRestauranteService {
    private final FormaPagamentoRestauranteRepository repository;
    private final RestauranteService restauranteService;
    private final FormaPagamentoService formaPagamentoService;

    public FormaPagamentoRestauranteResponse cadastrar(FormaPagamentoRestauranteRequest dto) {
        var formaPagamentoRestaurante = new FormaPagamentoRestaurante();
        var formaPagamento = formaPagamentoService.getFormaPagamentoPorId(dto.fkFormaPagamento());
        var restaurante = restauranteService.getRestaurantePorId(dto.fkRestaurante());

        formaPagamentoRestaurante.setFormaPagamento(formaPagamento);
        formaPagamentoRestaurante.setRestaurante(restaurante);

        BeanUtils.copyProperties(dto, formaPagamentoRestaurante);
        return new FormaPagamentoRestauranteResponse(repository.save(formaPagamentoRestaurante));
    }

    public List<FormaPagamentoRestauranteResponse> getFormasPagamentoRestauranteResponse() {
        return repository.findAllResponse();
    }

    public FormaPagamentoRestauranteResponse getFormaPagamentoRestauranteResponsePorId(UUID id) {
        return new FormaPagamentoRestauranteResponse(getFormaPagamentoRestaurantePorId(id));
    }

    public FormaPagamentoRestaurante getFormaPagamentoRestaurantePorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Forma de pagamento do restaurante com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }

    public FormaPagamentoRestauranteResponse alterar(UUID id, FormaPagamentoRestauranteRequest dto) {
        var formaPagamentoRestaurante = getFormaPagamentoRestaurantePorId(id);
        var formaPagamento = formaPagamentoService.getFormaPagamentoPorId(dto.fkFormaPagamento());
        var restaurante = restauranteService.getRestaurantePorId(dto.fkRestaurante());

        formaPagamentoRestaurante.setFormaPagamento(formaPagamento);
        formaPagamentoRestaurante.setRestaurante(restaurante);

        BeanUtils.copyProperties(dto, formaPagamentoRestaurante);
        return new FormaPagamentoRestauranteResponse(repository.save(formaPagamentoRestaurante));
    }

    public void deletarPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Forma de pagamento do restaurante com o id fornecido não existe"
            );

        repository.deleteById(id);
    }

    public List<FormaPagamentoRestauranteResponse> getFormasPagamentoPorRestaurante(UUID fkRestaurante) {
        return repository
                .findAllResponseByRestaurante(restauranteService.getRestaurantePorId(fkRestaurante));
    }
}
