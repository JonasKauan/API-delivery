package com.api_delivery.api_delivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "entregador")
@NoArgsConstructor
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEntregador;
    private String nome;
    private String email;
    private String senha;
    private String celular;
    // TODO Um upload do documento faria mais sentido
    private String carta;

    @OneToMany(mappedBy = "entregador")
    private List<Pedido> pedidos;

    public double getAvaliacao() {
        if(pedidos == null) return 0.;

        var avaliacao = pedidos.stream()
                .filter(pedido -> pedido.getDataHora().isAfter(LocalDateTime.now().minusDays(90)))
                .mapToDouble(Pedido::getAvaliacaoEntrega)
                .average();

        return avaliacao.isEmpty()
                ? 0.
                : avaliacao.getAsDouble();
    }
}
