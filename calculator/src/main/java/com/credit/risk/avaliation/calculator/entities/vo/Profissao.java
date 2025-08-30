package com.credit.risk.avaliation.calculator.entities.vo;

import java.util.Optional;

public class Profissao {
    private final String valor; // opcional

    public Profissao(String valor) {
        if (valor != null && valor.trim().isEmpty()) {
            throw new IllegalArgumentException("Profissão, se informada, não pode ser vazia");
        }
        this.valor = valor == null ? null : valor.trim();
    }

    public Optional<String> getValor() { return Optional.ofNullable(valor); }
}