package com.credit.risk.avaliation.calculator.entities.vo;

import java.util.Objects;

public class Nome {
    private final String valor;

    public Nome(String valor) {
        if (valor == null || valor.trim().length() < 2) {
            throw new IllegalArgumentException("Nome deve ter ao menos 2 caracteres");
        }
        this.valor = valor.trim();
    }

    public String getValor() { return valor; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nome)) return false;
        Nome nome = (Nome) o;
        return valor.equalsIgnoreCase(nome.valor);
    }

    @Override public int hashCode() { return Objects.hash(valor.toLowerCase()); }
}