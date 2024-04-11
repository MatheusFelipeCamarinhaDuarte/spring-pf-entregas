package br.com.fiap.springpfentregas.service;

import br.com.fiap.springpfentregas.dto.request.EnderecoRequest;
import br.com.fiap.springpfentregas.dto.response.EnderecoResponse;
import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class EnderecoService implements ServiceDTO<Endereco, EnderecoRequest, EnderecoResponse> {


    @Autowired
    private EnderecoRepository repo;

    @Autowired
    private PessoaService pessoaService;


    @Override
    public Endereco toEntity(EnderecoRequest enderecoRequest) {

        Pessoa pessoa = null;

        if (Objects.nonNull( enderecoRequest.pessoa().id() )) {
            pessoa = pessoaService.findById( enderecoRequest.pessoa().id() );
        }

        return Endereco.builder()
                .cep( enderecoRequest.cep() )
                .numero( enderecoRequest.numero() )
                .complemento( enderecoRequest.complemento() )
                .pessoa( pessoa )
                .build();
    }

    @Override
    public EnderecoResponse toResponse(Endereco endereco) {
        return EnderecoResponse.builder()
                .cep( endereco.getCep() )
                .numero( endereco.getNumero() )
                .complemento( endereco.getComplemento() )
                .pessoa( pessoaService.toResponse( endereco.getPessoa() ) )
                .build();
    }

    @Override
    public Collection<Endereco> findAll() {
        return repo.findAll();
    }

    @Override
    public Endereco findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Endereco save(Endereco endereco) {
        return repo.save( endereco );
    }

    public List<Endereco> findByCep(String cep) {
        return repo.findByCep( cep );
    }
}
