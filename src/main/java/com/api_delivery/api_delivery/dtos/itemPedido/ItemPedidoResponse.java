package com.api_delivery.api_delivery.dtos.itemPedido;

import com.api_delivery.api_delivery.dtos.item.ItemResponse;
import com.api_delivery.api_delivery.dtos.pedido.PedidoResponse;
import com.api_delivery.api_delivery.models.ItemPedido;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ItemPedidoResponse {
    private final UUID idItemPedido;
    private final ItemResponse item;
    private final PedidoResponse pedido;
    private final Integer quantidade;
    private final Double valor;

    public ItemPedidoResponse(ItemPedido item) {
        this.idItemPedido = item.getIdItemPedido();
        this.item = new ItemResponse(item.getItem());
        this.pedido = new PedidoResponse(item.getPedido());
        this.quantidade = item.getQuantidade();
        this.valor = item.getValor();
    }
}
