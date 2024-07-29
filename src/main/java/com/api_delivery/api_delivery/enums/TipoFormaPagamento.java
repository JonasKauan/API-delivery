package com.api_delivery.api_delivery.enums;

import lombok.Getter;

@Getter
public enum TipoFormaPagamento {
    PELO_APP(1, "pago pelo app"),
    NA_ENTREGA(2, "pago na entrega");

    private final int codigo;
    private final String alias;

    TipoFormaPagamento(int codigo, String alias) {
        this.codigo = codigo;
        this.alias = alias;
    }

    public static TipoFormaPagamento valueOf(int codigo) {

        for(TipoFormaPagamento tipo : TipoFormaPagamento.values()) {
            if(tipo.codigo == codigo) return tipo;
        }

        throw new IllegalArgumentException("Código de tipo de forma de pagamento inválido");
    }
}
