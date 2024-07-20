package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;
    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;

    @Column(unique = true)
    private String celular;

    public Usuario(UUID idUsuario, String nome, String email, String celular) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }
}
