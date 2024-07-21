package com.api_delivery.api_delivery.services;

import com.api_delivery.api_delivery.dtos.formaPagamento.FormaPagamentoResponse;
import com.api_delivery.api_delivery.models.FormaPagamento;
import com.api_delivery.api_delivery.repositories.FormaPagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FormaPagamentoService {
    private final FormaPagamentoRepository repository;

    public List<FormaPagamentoResponse> getFormasPagamentoResponse() {
        return repository.findAllResponse();
    }

    public FormaPagamentoResponse getFormaPagamentoResponsePorId(UUID id) {
        return new FormaPagamentoResponse(getFormaPagamentoPorId(id));
    }

    public FormaPagamento getFormaPagamentoPorId(UUID id) {
        if(!repository.existsById(id))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Forma de pagamento com o id fornecido não existe"
            );

        return repository.findById(id).get();
    }
}
