package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idItem;

    @ManyToOne
    @JoinColumn(name = "fkrestaurante")
    private Restaurante restaurante;

    private String nome;
    private Double valor;
}
