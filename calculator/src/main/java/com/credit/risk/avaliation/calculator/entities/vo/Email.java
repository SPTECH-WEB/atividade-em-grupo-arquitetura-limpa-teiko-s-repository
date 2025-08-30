package com.credit.risk.avaliation.calculator.entities.vo;

import java.util.Objects;

public class Email {
    private final String valor;

    public Email(String valor) {
        if (valor == null || !valor.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.valor = valor.trim();
    }

    public String getValor() { return valor; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return valor.equalsIgnoreCase(email.valor);
    }

    @Override public int hashCode() { return Objects.hash(valor.toLowerCase()); }
}