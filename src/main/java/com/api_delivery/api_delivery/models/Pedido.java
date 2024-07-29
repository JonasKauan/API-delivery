package com.api_delivery.api_delivery.models;

import com.api_delivery.api_delivery.enums.StatusPedido;
import com.api_delivery.api_delivery.enums.TipoFormaPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "pedido")
@NoArgsConstructor
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
    @JoinColumn(name = "fkforma_pagamento_restaurante")
    private FormaPagamentoRestaurante formaPagamento;

    @ManyToOne
    @JoinColumn(name = "fkentregador")
    private Entregador entregador;

    @Embedded
    private Endereco endereco;
    private double valor;
    private LocalDateTime dataHoraRealizado;
    private LocalDateTime dataHoraConcluido;
    private int statusPedido;
    private Integer avaliacaoRestaurante;
    private Integer avaliacaoEntrega;

    public Pedido(
            FormaPagamentoRestaurante formaPagamento,
            Restaurante restaurante
    ) {
        this.dataHoraRealizado = LocalDateTime.now();
        this.restaurante = restaurante;
        this.formaPagamento = formaPagamento;
        this.statusPedido = formaPagamento.getTipoFormaPagamento() == TipoFormaPagamento.PELO_APP
                ? 1
                : 2;
    }

    public Pedido(
            UUID idPedido,
            Restaurante restaurante,
            Usuario usuario,
            FormaPagamentoRestaurante formaPagamento,
            Entregador entregador,
            Double valor,
            LocalDateTime dataHoraRealizado,
            LocalDateTime dataHoraConcluido,
            int statusPedido,
            Integer avaliacaoRestaurante,
            Integer avaliacaoEntrega,
            Endereco endereco
    ) {
        this.idPedido = idPedido;
        this.restaurante = restaurante;
        this.usuario = usuario;
        this.formaPagamento = formaPagamento;
        this.entregador = entregador;
        this.valor = valor;
        this.dataHoraRealizado = dataHoraRealizado;
        this.dataHoraConcluido = dataHoraConcluido;
        this.statusPedido = statusPedido;
        this.avaliacaoRestaurante = avaliacaoRestaurante;
        this.avaliacaoEntrega = avaliacaoEntrega;
        this.endereco = endereco;
    }

    public Pedido(
            UUID idPedido,
            Restaurante restaurante,
            Usuario usuario,
            FormaPagamentoRestaurante formaPagamento,
            Double valor,
            LocalDateTime dataHoraRealizado,
            LocalDateTime dataHoraConcluido,
            int statusPedido,
            Integer avaliacaoRestaurante,
            Integer avaliacaoEntrega,
            Endereco endereco
    ) {
        this.idPedido = idPedido;
        this.restaurante = restaurante;
        this.usuario = usuario;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
        this.dataHoraRealizado = dataHoraRealizado;
        this.dataHoraConcluido = dataHoraConcluido;
        this.statusPedido = statusPedido;
        this.avaliacaoRestaurante = avaliacaoRestaurante;
        this.avaliacaoEntrega = avaliacaoEntrega;
        this.endereco = endereco;
    }


    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setEndereco(Object e) {
        if(e instanceof EnderecoUsuario enderecoUsuario) {
            var endereco = new Endereco();
            BeanUtils.copyProperties(enderecoUsuario, endereco);
            this.endereco = endereco;
        }else if(e instanceof Endereco endereco) {
            this.endereco = endereco;
        }
    }
}
