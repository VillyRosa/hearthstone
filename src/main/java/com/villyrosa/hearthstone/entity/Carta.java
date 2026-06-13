package com.villyrosa.hearthstone.entity;

import com.villyrosa.hearthstone.enums.ClasseCarta;
import com.villyrosa.hearthstone.enums.TipoCarta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cartas")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Min(0)
    @Max(10)
    @Column(name = "custo_mana", nullable = false)
    private Integer custoMana;

    @Min(0)
    @Max(10)
    @Column(nullable = false)
    private Integer ataque;

    @Min(0)
    @Max(10)
    @Column(nullable = false)
    private Integer defesa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCarta tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClasseCarta classe;

}
