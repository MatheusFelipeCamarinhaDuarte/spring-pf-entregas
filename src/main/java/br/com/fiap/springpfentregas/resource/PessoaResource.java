package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.dto.request.PessoaRequest;
import br.com.fiap.springpfentregas.dto.response.PessoaResponse;
import br.com.fiap.springpfentregas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<PessoaResponse> findAll() {
        return service.findAll().stream().map( service::toResponse ).toList();
    }

    @GetMapping(value = "/{id}")
    public PessoaResponse findById(@PathVariable Long id) {
        return service.toResponse( service.findById( id ) );
    }

    @Transactional
    @PostMapping
    public PessoaResponse save(@RequestBody PessoaRequest pessoa) {
        if (Objects.isNull( pessoa )) return null;
        var entity = service.toEntity( pessoa );
        var saved = service.save( entity );
        return service.toResponse( saved );
    }


}
