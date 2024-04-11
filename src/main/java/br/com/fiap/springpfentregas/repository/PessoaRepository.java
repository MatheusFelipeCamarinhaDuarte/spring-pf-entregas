package br.com.fiap.springpfentregas.repository;


import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
