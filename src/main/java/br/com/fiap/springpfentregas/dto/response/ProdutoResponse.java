package br.com.fiap.springpfentregas.dto.response;

public record ProdutoResponse(
        Long id,
        String nome,
        String etiqueta,
        Float peso,
        Float altura,
        Float largura,
        Float profundidade
) {
}
