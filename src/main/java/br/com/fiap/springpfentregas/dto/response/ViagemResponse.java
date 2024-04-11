package br.com.fiap.springpfentregas.dto.response;

import br.com.fiap.springpfentregas.dto.request.AbstractRequest;
import br.com.fiap.springpfentregas.dto.request.EnderecoRequest;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Collection;

@Builder
public record ViagemResponse(
        Long id,
        Collection<ProdutoResponse> produtos,
        Collection<PassageiroResponse> passageiros,
        PessoaResponse cliente,
        EnderecoResponse origem,
        EnderecoResponse destino,
        LocalDateTime saida,
        LocalDateTime chegada
) {
}
