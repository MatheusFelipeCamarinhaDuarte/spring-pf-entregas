package br.com.fiap.springpfentregas.service;

import br.com.fiap.springpfentregas.dto.request.PessoaRequest;
import br.com.fiap.springpfentregas.dto.response.PessoaResponse;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PessoaService implements ServiceDTO<Pessoa, PessoaRequest, PessoaResponse> {

    @Autowired
    private PessoaRepository repo;

    @Override
    public Pessoa toEntity(PessoaRequest pessoaRequest) {

        return Pessoa.builder()
                .nome( pessoaRequest.nome() )
                .email( pessoaRequest.email() )
                .nascimento( pessoaRequest.nascimento() )
                .build();
    }

    @Override
    public PessoaResponse toResponse(Pessoa pessoa) {

        return PessoaResponse.builder()
                .id( pessoa.getId() )
                .nome( pessoa.getNome() )
                .email( pessoa.getEmail() )
                .nascimento( pessoa.getNascimento() )
                .build();
    }

    @Override
    public Collection<Pessoa> findAll() {
        return repo.findAll();
    }

    @Override
    public Pessoa findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repo.save( pessoa );
    }
}
