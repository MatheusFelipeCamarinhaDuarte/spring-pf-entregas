package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.dto.request.EnderecoRequest;
import br.com.fiap.springpfentregas.dto.response.EnderecoResponse;
import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import br.com.fiap.springpfentregas.service.EnderecoService;
import br.com.fiap.springpfentregas.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @Autowired
    private PessoaService pessoaService;


    @GetMapping
    public Collection<EnderecoResponse> findAll() {
        var entity = service.findAll();
        var response = entity
                .stream().map(service::toResponse).toList();
        return response;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<EnderecoResponse> save(@RequestBody @Valid EnderecoRequest endereco) {

        var entity = service.toEntity(endereco);

        var pessoa = pessoaService.findById(endereco.pessoa().id());

        if (Objects.nonNull(pessoa)) entity.setPessoa(pessoa);


        Endereco save = service.save(entity);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/{id}")
                .buildAndExpand(save.getId())
                .toUri();

        var response = service.toResponse(save);

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping(value = "/cep/{cep}")
    public List<Endereco> findByCep(@PathVariable String cep) {
        return service.findByCep(cep);
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public List<Endereco> findByPessoaId(@PathVariable Long idPessoa) {
        return service.findByPessoaId(idPessoa);
    }


}
