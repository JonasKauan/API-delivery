package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPedido;

    @ManyToOne
    @JoinColumn(name = "fkrestaurante")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "fkusuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fkentregador")
    private Entregador entregador;

    private Double valor;
    private LocalDateTime dataHora;
    private Integer avaliacaoRestaurante;
    private Integer avaliacaoEntrega;
}
