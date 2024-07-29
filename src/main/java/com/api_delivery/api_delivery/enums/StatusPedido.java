package com.api_delivery.api_delivery.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {
    AGUARDANDO_PAGAMENTO(1, "aguardando pagamento"),
    AGUARDANDO_CONFIRMACAO_RESTAURANTE(2, "aguardando confirmação do restaurante"),
    EM_PREPARO(3, "em preparo"),
    A_CAMINHO(4, "a caminho"),
    ENTREGUE(5, "entregue");

    private final int codigo;
    private final String alias;

    StatusPedido(int codigo, String alias) {
        this.codigo = codigo;
        this.alias = alias;
    }

    public static StatusPedido valueOf(int codigo) {
        for(StatusPedido status : StatusPedido.values()) {
            if(status.getCodigo() == codigo) return status;
        }

        throw new IllegalArgumentException("Codigo de status do pedido inválido");
    }
}
