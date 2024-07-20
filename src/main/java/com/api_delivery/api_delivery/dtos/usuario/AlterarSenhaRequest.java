package com.api_delivery.api_delivery.dtos.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AlterarSenhaRequest(
    String senhaAntiga,
    @NotBlank
    @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
    String senhaNova
) {}
