package com.credit.risk.avaliation.calculator.entities.vo;

public class Idade {
    private final int valor;

    public Idade(int valor) {
        if (valor <= 0) throw new IllegalArgumentException("Idade deve ser positiva");
        this.valor = valor;
    }

    public int getValor() { return valor; }
}