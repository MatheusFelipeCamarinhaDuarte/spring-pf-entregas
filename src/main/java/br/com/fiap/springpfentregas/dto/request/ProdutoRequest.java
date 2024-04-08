package br.com.fiap.springpfentregas.dto.request;

import jakarta.validation.constraints.NotNull;

public record ProdutoRequest(
        @NotNull(message = "O atributo nome é obrigatório")
        String nome,



        Float peso,

        Float altura,

        Float largura,

        Float profundidade


) {
}
