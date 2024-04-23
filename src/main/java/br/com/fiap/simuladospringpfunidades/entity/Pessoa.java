package br.com.fiap.simuladospringpfunidades.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TBL_2TDSPF_PESSOA",
            uniqueConstraints = {
        //Não tem como duas pessoas ter o mesmo email
        @UniqueConstraint(name = "UK_PESSOA_EMAIL", columnNames = {"EMAIL"})
            })
public class Pessoa {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "SQ_PESSOA")
    @SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NM_PESSOA")
    private String nome;

    @Column(name = "SOBRENOME_PESSOA")
    private String sobrenome;

    @Column(name = "EMAIL_PESSOA")
    private String email;

    @Column(name = "DT_NASCIMENTO_PESSOA")
    private LocalDate nascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PESSOA", nullable = false)
    private Tipo tipo;

}
