package com.credit.risk.avaliation.calculator.adapters.in.web.dtos;

import java.util.UUID;

public class ClienteResponse {
    public UUID id;
    public String nome;
    public String email;
    public String telefone;
    public String cpf;
    public double rendaMensal;
    public int idade;
    public String profissao;

    public String risco;
    public String estrategiaContato;
    public int prioridade;
}
