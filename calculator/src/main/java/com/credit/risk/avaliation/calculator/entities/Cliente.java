package com.credit.risk.avaliation.calculator.entities;

import com.credit.risk.avaliation.calculator.entities.vo.*;

import java.util.UUID;

public class Cliente {
    private final UUID id;
    private final Nome nome;
    private final Email email;
    private final Telefone telefone;
    private final Cpf cpf;
    private final RendaMensal rendaMensal;
    private final Idade idade;
    private final Profissao profissao;

    public Cliente(
            UUID id,
            Nome nome,
            Email email,
            Telefone telefone,
            Cpf cpf,
            RendaMensal rendaMensal,
            Idade idade,
            Profissao profissao) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.idade = idade;
        this.profissao = profissao;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome.getValor();
    }

    public String getEmail() {
        return email.getValor();
    }

    public String getTelefone() {
        return telefone.getValorNormalizado();
    }

    public String getCpf() {
        return cpf.getValor();
    }

    public double getRendaMensal() {
        return rendaMensal.getValor();
    }

    public int getIdade() {
        return idade.getValor();
    }

    public String getProfissao() {
        return profissao.getValor().orElse(null);
    }
}