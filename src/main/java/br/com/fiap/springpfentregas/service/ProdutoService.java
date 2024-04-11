package br.com.fiap.springpfentregas.service;

import br.com.fiap.springpfentregas.dto.request.ProdutoRequest;
import br.com.fiap.springpfentregas.dto.response.ProdutoResponse;
import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse> {


    @Autowired
    private ProdutoRepository repo;


    @Override
    public Produto toEntity(ProdutoRequest produtoRequest) {

        if (Objects.isNull(produtoRequest)) return null;

        return Produto.builder()
                .nome(produtoRequest.nome())
                .peso(produtoRequest.peso())
                .altura(produtoRequest.altura())
                .largura(produtoRequest.largura())
                .profundidade(produtoRequest.profundidade())
                .build();
    }

    @Override
    public ProdutoResponse toResponse(Produto produto) {

        if (Objects.isNull(produto)) return null;

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getEtiqueta(),
                produto.getPeso(),
                produto.getAltura(),
                produto.getLargura(),
                produto.getProfundidade());
    }

    @Override
    public Collection<Produto> findAll() {
        return repo.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Produto save(Produto produto) {
        if(Objects.isNull(produto)) return null;
        var etiqueta = UUID.randomUUID().toString();
        produto.setEtiqueta(etiqueta);
        return repo.save(produto);
    }
}
