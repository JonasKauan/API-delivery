package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEndereco;

    @ManyToOne
    @JoinColumn(name = "fkusuario")
    private Usuario usuario;
    private String apelido;
    private String rua;
    private Integer numero;
    private String complemento;
}
