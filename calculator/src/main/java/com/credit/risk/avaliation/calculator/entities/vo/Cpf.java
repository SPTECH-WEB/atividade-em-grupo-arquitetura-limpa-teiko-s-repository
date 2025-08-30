package com.credit.risk.avaliation.calculator.entities.vo;

import java.util.Objects;

public class Cpf {
    private final String valor;

    public Cpf(String valor) {
        if (valor == null || !valor.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido. Use o formato XXX.XXX.XXX-XX");
        }
        this.valor = valor;
    }

    public String getValor() { return valor; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpf)) return false;
        Cpf cpf = (Cpf) o;
        return valor.equals(cpf.valor);
    }

    @Override public int hashCode() { return Objects.hash(valor); }
}