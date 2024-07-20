package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.categoriaItem.CategoriaItemResponse;
import com.api_delivery.api_delivery.models.CategoriaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoriaItemRepository extends JpaRepository<CategoriaItem, UUID> {
    @Query("SELECT c FROM CategoriaItem c")
    List<CategoriaItemResponse> findAllResponse();
}
