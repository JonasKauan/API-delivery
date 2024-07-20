package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.categoriaRestaurante.CategoriaRestauranteResponse;
import com.api_delivery.api_delivery.models.CategoriaRestaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoriaRestauranteRepository extends JpaRepository<CategoriaRestaurante, UUID> {

    @Query("SELECT c FROM CategoriaRestaurante c")
    List<CategoriaRestauranteResponse> findAllResponse();
}
