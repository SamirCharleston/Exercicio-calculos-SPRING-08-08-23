package com.example.exercicio.exercicio.service;
import com.example.exercicio.exercicio.entity.OperacaoEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OperacaoService {
    private List<BigDecimal> valoresArmazenados = new ArrayList<BigDecimal>();
    public OperacaoEntity efetuarOperacoes(){
        OperacaoEntity operacao = new OperacaoEntity();
        operacao.setResultadoDesvioPadrao(desvioPadrao());
        operacao.setResultadoMediana(mediana());
        operacao.setResultadoMedia(xMedia());
        return operacao;
    }
    public double desvioPadrao(){
        double[] numeros = new double[valoresArmazenados.size()];
        int j = 0;
        int n = valoresArmazenados.size();
        for(BigDecimal valor : valoresArmazenados){
            numeros[j] = valor.floatValue();
            j++;
        }
        double media = calcularMedia(numeros);
        double somaDiferencasQuadrado = 0.0;
        for (int i = 0; i < n; i++) {
            somaDiferencasQuadrado += Math.pow(numeros[i] - media, 2);
        }

        double desvioPadrao = Math.sqrt(somaDiferencasQuadrado / n);
        return desvioPadrao;
    }

    public static double calcularMedia(double[] numeros) {
        double soma = 0.0;
        for (double numero : numeros) {
            soma += numero;
        }
        return soma / numeros.length;
    }

    public double mediana(){
        double [] numeros = new double[valoresArmazenados.size()];
        int i = 0;
        for(BigDecimal valor : valoresArmazenados){
            numeros[i] = valor.floatValue();
        }
        int n = valoresArmazenados.size();
        Arrays.sort(numeros);
        double mediana;

        if (n % 2 == 0) {
            int meio1 = n / 2 - 1;
            int meio2 = n / 2;
            mediana = (numeros[meio1] + numeros[meio2]) / 2;
        } else {
            int meio = n / 2;
            mediana = numeros[meio];
        }
        return mediana;
    }
    public double xMedia(){
        double valor = 0;
        for(BigDecimal val : valoresArmazenados){
            valor += val.doubleValue();
        }
        return valor / valoresArmazenados.size();
    }
    public String armazenarValor(BigDecimal valor){
        this.valoresArmazenados.add(valor);
        return "Valor armazenado!";
    }
}
