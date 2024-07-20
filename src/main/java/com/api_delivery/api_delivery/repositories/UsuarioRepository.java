package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.usuario.UsuarioResponse;
import com.api_delivery.api_delivery.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    @Query("SELECT new Usuario(u.idUsuario, u.nome, u.email, u.celular) FROM Usuario u")
    List<UsuarioResponse> findAllResponse();

    boolean existsByEmail(String email);

    boolean existsByCelular(String celular);
}
