package com.api_delivery.api_delivery.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Endereco {
    private String rua;
    private Integer numero;
    private String complemento;
}
