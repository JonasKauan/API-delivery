package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idItemPedido;

    @ManyToOne
    @JoinColumn(name = "fkitem")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "fkpedido")
    private Pedido pedido;

    private Integer quantidade;
    private Double valor;
}
