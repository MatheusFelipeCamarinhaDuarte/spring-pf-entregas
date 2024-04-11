package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_PASSAGEIRO")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PASSAGEIRO")
    @SequenceGenerator(name = "SQ_PASSAGEIRO", sequenceName = "SQ_PASSAGEIRO", allocationSize = 1)
    @Column(name = "ID_PASSAGEIRO")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_PASSAGEIRO_PESSOA"
            )
    )
    private Pessoa pessoa;

    private Boolean temMalas;

    private Boolean desejaArCondicionado;


}
