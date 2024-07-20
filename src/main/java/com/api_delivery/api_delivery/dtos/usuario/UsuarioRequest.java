package com.api_delivery.api_delivery.dtos.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
        String senha,
        @NotBlank
        @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$")
        String celular
) {}
