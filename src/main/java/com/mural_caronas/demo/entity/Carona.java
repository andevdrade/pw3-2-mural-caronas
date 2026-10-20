package com.mural_caronas.demo.entity;

import com.mural_caronas.demo.enums.StatusCaronaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_CARONA")

public class Carona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARONA")
    private Long id;

    @Column(name = "TX_NOMEMOTORISTAOULIDER")
    private String nome;

    @Column(name = "TX_BAIRROORIGEM")
    private  String bairroOirgem;

    @Column(name = "DT_HORARIOSAIDA")
    private LocalDateTime horarioSaida;

    @Column(name = "NR_VAGASDISPONIVEIS")
    private Double vagasDisponiveis;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_STATUS")
    private StatusCaronaEnum status;
}
