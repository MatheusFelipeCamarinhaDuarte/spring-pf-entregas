package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.dto.request.ProdutoRequest;
import br.com.fiap.springpfentregas.dto.response.ProdutoResponse;
import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import br.com.fiap.springpfentregas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }


    @GetMapping(value = "/{id}")
    public ProdutoResponse findById(@PathVariable Long id) {
        Produto produto = service.findById(id);
        return service.toResponse(produto);
    }


    @Transactional
    @PostMapping
    public ProdutoResponse save(@RequestBody ProdutoRequest produto) {
        Produto save = service.save(service.toEntity(produto));
        return service.toResponse(save);
    }


}
