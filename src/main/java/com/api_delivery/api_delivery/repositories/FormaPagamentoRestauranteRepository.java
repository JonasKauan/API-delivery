package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.formaPagamentoRestaurante.FormaPagamentoRestauranteResponse;
import com.api_delivery.api_delivery.models.FormaPagamentoRestaurante;
import com.api_delivery.api_delivery.models.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FormaPagamentoRestauranteRepository extends JpaRepository<FormaPagamentoRestaurante, UUID> {

    @Query("SELECT f FROM FormaPagamentoRestaurante f")
    List<FormaPagamentoRestauranteResponse> findAllResponse();

    @Query("SELECT f FROM FormaPagamentoRestaurante f WHERE f.restaurante = ?1")
    List<FormaPagamentoRestauranteResponse> findAllResponseByRestaurante(Restaurante restaurante);
}
