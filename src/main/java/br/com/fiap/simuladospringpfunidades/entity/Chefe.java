package br.com.fiap.simuladospringpfunidades.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TBL_2TDSPF_CHEFE",
                uniqueConstraints = {
        // Não tem como outras unidades terem o mesmo chefe
        @UniqueConstraint(name = "UK_CHEFE_UNIDADE", columnNames = {"USUARIO", "UNIDADE", "DT_FIM"})
})

public class Chefe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "SQ_CHEFE")
    @SequenceGenerator(name = "SQ_CHEFE", sequenceName = "SQ_CHEFE", allocationSize = 1)
    @Column(name = "ID_CHEFE")
    private Long id;

    @Column(name = "SUBSTITUTO")
    private Boolean substituto;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(
                    name = "FK_USUARIO_CHEFE"
            )
    )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(
            name = "UNIDADE",
            referencedColumnName = "ID_UNIDADE",
            foreignKey = @ForeignKey(
                    name = "FK_UNIDADE_CHEFE"
            )
    )
    private Unidade unidade;

    @Column(name = "DT_INICIO")
    private LocalDateTime inicio;

    @Column(name = "DT_FIM")
    private LocalDateTime fim;

}
