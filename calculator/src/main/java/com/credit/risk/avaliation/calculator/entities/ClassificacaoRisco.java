package com.credit.risk.avaliation.calculator.entities;

public class ClassificacaoRisco {
    private final RiscoCredito risco;
    private final String estrategiaContato;
    private final int prioridade;

    public ClassificacaoRisco(RiscoCredito risco, String estrategiaContato, int prioridade) {
        this.risco = risco;
        this.estrategiaContato = estrategiaContato;
        this.prioridade = prioridade;
    }

    public RiscoCredito getRisco() { return risco; }
    public String getEstrategiaContato() { return estrategiaContato; }
    public int getPrioridade() { return prioridade; }
}