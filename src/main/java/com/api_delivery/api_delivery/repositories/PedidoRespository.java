package com.api_delivery.api_delivery.repositories;

import com.api_delivery.api_delivery.dtos.pedido.PedidoResponse;
import com.api_delivery.api_delivery.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRespository extends JpaRepository<Pedido, UUID> {

    @Query("""
            SELECT new Pedido(
                p.idPedido,
                p.restaurante,
                new Usuario(p.usuario.idUsuario, p.usuario.nome, p.usuario.email, p.usuario.celular),
                p.formaPagamento,
                p.valor,
                p.dataHoraRealizado,
                p.dataHoraConcluido,
                p.statusPedido,
                p.avaliacaoRestaurante,
                p.avaliacaoEntrega,
                p.endereco
            )
            FROM Pedido p
            """)
    List<PedidoResponse> findAllResponse();
}
