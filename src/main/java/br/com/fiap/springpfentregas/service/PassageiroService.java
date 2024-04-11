package br.com.fiap.springpfentregas.service;

import br.com.fiap.springpfentregas.dto.request.PassageiroRequest;
import br.com.fiap.springpfentregas.dto.response.PassageiroResponse;
import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class PassageiroService implements ServiceDTO<Passageiro, PassageiroRequest, PassageiroResponse> {

    @Autowired
    private PassageiroRepository repo;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public Passageiro toEntity(PassageiroRequest passageiroRequest) {
        if (Objects.isNull( passageiroRequest.pessoa().id() )) return null;
        var pessoa = pessoaService.findById( passageiroRequest.pessoa().id() );
        if (Objects.isNull( pessoa )) return null;

        return Passageiro.builder()
                .pessoa( pessoa )
                .build();
    }

    @Override
    public PassageiroResponse toResponse(Passageiro passageiro) {
        if (Objects.isNull( passageiro )) return null;
        var pessoa = pessoaService.toResponse( passageiro.getPessoa() );
        return PassageiroResponse.builder()
                .id( passageiro.getId() )
                .pessoa( pessoa )
                .build();
    }

    @Override
    public Collection<Passageiro> findAll() {
        return repo.findAll();
    }

    @Override
    public Passageiro findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Passageiro save(Passageiro passageiro) {
        return repo.save( passageiro );
    }
}
