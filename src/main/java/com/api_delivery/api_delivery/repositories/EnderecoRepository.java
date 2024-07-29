package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.endereco.EnderecoResponse;
import com.api_delivery.api_delivery.models.EnderecoUsuario;
import com.api_delivery.api_delivery.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoUsuario, UUID> {

    @Query("SELECT e FROM EnderecoUsuario e")
    List<EnderecoResponse> findAllResponse();

    @Query("SELECT e FROM EnderecoUsuario e WHERE e.usuario = ?1")
    List<EnderecoResponse> findAllResponseByUsuario(Usuario usuario);
}
