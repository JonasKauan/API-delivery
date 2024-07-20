package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.item.ItemResponse;
import com.api_delivery.api_delivery.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    @Query("SELECT i FROM Item i")
    List<ItemResponse> findAllResponse();
}
