package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.restaurante.RestauranteResponse;
import com.api_delivery.api_delivery.models.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {

    @Query("SELECT r FROM Restaurante r")
    List<RestauranteResponse> findAllResponse();
}
