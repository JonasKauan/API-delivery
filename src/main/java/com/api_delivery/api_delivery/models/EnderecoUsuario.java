package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "endereco")
@ToString
public class EnderecoUsuario {

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
