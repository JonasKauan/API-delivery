package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "entregador")
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEntregador;
    private String nome;
    private String email;
    private String senha;
    private String celular;
    private String carta;
    private Double avaliacao;
}
