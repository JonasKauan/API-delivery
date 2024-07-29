package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idRestaurante;

    @ManyToOne
    @JoinColumn(name = "fkcategoria_restaurante")
    private CategoriaRestaurante categoriaRestaurante;

    private String nome;
    private String email;
    private String senha;
    private LocalDate dataEntradaPlataforma;
    private Double taxaEntrega;

    public Restaurante() {
        this.dataEntradaPlataforma = LocalDate.now();
    }
}
