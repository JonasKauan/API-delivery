package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "categoria_restaurante")
public class CategoriaRestaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCategoriaRestaurante;
    private String nome;
}
