package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.formaPagamento.FormaPagamentoResponse;
import com.api_delivery.api_delivery.models.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, UUID> {

    @Query("SELECT f FROM FormaPagamento f")
    List<FormaPagamentoResponse> findAllResponse();
}
