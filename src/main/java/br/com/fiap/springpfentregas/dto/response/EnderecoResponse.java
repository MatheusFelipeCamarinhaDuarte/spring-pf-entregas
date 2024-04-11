package br.com.fiap.springpfentregas.dto.response;

import lombok.Builder;

@Builder
public record EnderecoResponse(
        Long id,
        String cep,
        String numero,
        String complemento,
        PessoaResponse pessoa
) {
}
