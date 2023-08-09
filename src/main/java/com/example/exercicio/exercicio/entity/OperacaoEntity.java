package com.example.exercicio.exercicio.entity;

import lombok.Getter;
import lombok.Setter;

public class OperacaoEntity {
    @Getter @Setter
    private double resultadoDesvioPadrao;
    @Setter @Getter
    private double resultadoMedia;
    @Setter @Getter
    private double resultadoMediana;

}
