package br.com.fiap.springpfentregas.repository;


import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
}
