package com.credit.risk.avaliation.calculator.entities.vo;

public class RendaMensal {
    private final double valor;

    public RendaMensal(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("Renda mensal deve ser positiva");
        this.valor = valor;
    }

    public double getValor() { return valor; }
}