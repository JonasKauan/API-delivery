package com.api_delivery.api_delivery.models;

import com.api_delivery.api_delivery.enums.TipoFormaPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "forma_pagamento_restaurante")
public class FormaPagamentoRestaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFormaPagamentoRestaurante;

    @ManyToOne
    @JoinColumn(name = "fkforma_pagamento")
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "fkrestaurante")
    private Restaurante restaurante;

    private int percentualDesconto;
    private int tipoFormaPagamento;

    public TipoFormaPagamento getTipoFormaPagamento() {
        return TipoFormaPagamento.valueOf(tipoFormaPagamento);
    }
}
