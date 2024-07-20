package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.entregador.EntregadorResponse;
import com.api_delivery.api_delivery.models.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, UUID> {
    boolean existsByEmail(String email);

    boolean existsByCelular(String celular);

    @Query("SELECT e FROM Entregador e")
    List<EntregadorResponse> findAllResponse();
}
