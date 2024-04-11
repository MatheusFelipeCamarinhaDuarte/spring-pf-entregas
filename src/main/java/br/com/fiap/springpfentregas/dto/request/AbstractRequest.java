package br.com.fiap.springpfentregas.dto.request;

import jakarta.validation.constraints.NotNull;

public record AbstractRequest(
        @NotNull(message = "O id é campo obrigatório")
        Long id
) {
}
