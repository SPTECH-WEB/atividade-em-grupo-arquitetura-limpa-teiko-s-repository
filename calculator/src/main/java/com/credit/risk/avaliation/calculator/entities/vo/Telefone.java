package com.credit.risk.avaliation.calculator.entities.vo;

import java.util.Objects;

public class Telefone {
    private final String digits;

    public Telefone(String valor) {
        if (valor == null) throw new IllegalArgumentException("Telefone obrigatório");
        String somenteDigitos = valor.replaceAll("\\D", "");
        if (somenteDigitos.length() < 10) {
            throw new IllegalArgumentException("Telefone deve conter ao menos 10 dígitos");
        }
        this.digits = somenteDigitos;
    }

    public String getValorNormalizado() { return digits; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefone)) return false;
        Telefone that = (Telefone) o;
        return digits.equals(that.digits);
    }

    @Override public int hashCode() { return Objects.hash(digits); }
}