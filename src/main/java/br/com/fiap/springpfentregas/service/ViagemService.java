package br.com.fiap.springpfentregas.service;

import br.com.fiap.springpfentregas.dto.request.ViagemRequest;
import br.com.fiap.springpfentregas.dto.response.ViagemResponse;
import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViagemService implements ServiceDTO<Viagem, ViagemRequest, ViagemResponse> {

    @Autowired
    private ViagemRepository repo;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PassageiroService passageiroService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Viagem toEntity(ViagemRequest request) {

        if (Objects.isNull( request.cliente().id() )) return null;

        var cliente = pessoaService.findById( request.cliente().id() );

        if (Objects.isNull( cliente )) return null;

        if (Objects.isNull( request.origem() )) return null;
        if (Objects.isNull( request.destino() )) return null;


        Set<Produto> produtos = new LinkedHashSet<>();

        request.produtos().forEach( produto -> {
            if (Objects.nonNull( produto.id() )) {
                var p = produtoService.findById( produto.id() );
                if (p != null) {
                    produtos.add( p );
                }
            }
        } );

        Set<Passageiro> passageiros = new LinkedHashSet<>();

        request.produtos().forEach( passageiro -> {
            if (Objects.nonNull( passageiro.id() )) {
                var p = passageiroService.findById( passageiro.id() );
                if (p != null) {
                    passageiros.add( p );
                }
            }
        } );

        var origem = enderecoService.toEntity( request.origem() );

        var destino = enderecoService.toEntity( request.destino() );

        return Viagem.builder()
                .cliente( cliente )
                .produtos( produtos )
                .passageiros( passageiros )
                .origem( origem )
                .destino( destino )
                .saida( request.saida() )
                .chegada( request.chegada() )
                .build();
    }

    @Override
    public ViagemResponse toResponse(Viagem viagem) {
        return null;
    }

    @Override
    public Collection<Viagem> findAll() {
        return List.of();
    }

    @Override
    public Viagem findById(Long id) {
        return null;
    }

    @Override
    public Viagem save(Viagem viagem) {
        return null;
    }
}
