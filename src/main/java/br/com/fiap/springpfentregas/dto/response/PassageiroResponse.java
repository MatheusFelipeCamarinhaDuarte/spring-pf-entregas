package br.com.fiap.springpfentregas.dto.response;

import lombok.Builder;

@Builder
public record PassageiroResponse(
        Long id,
        PessoaResponse pessoa
) {
}
