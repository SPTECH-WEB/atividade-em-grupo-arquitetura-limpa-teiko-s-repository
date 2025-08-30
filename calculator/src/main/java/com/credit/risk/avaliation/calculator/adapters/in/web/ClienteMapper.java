package com.credit.risk.avaliation.calculator.adapters.in.web;

import com.credit.risk.avaliation.calculator.adapters.in.web.dtos.ClienteRequest;
import com.credit.risk.avaliation.calculator.adapters.in.web.dtos.ClienteResponse;
import com.credit.risk.avaliation.calculator.entities.Cliente;
import com.credit.risk.avaliation.calculator.entities.vo.*;

public class ClienteMapper {

    public Cliente toDomain(ClienteRequest r) {
        return new Cliente(
                null,
                new Nome(r.getNome()),
                new Email(r.getEmail()),
                new Telefone(r.getTelefone()),
                new Cpf(r.getCpf()),
                new RendaMensal(r.getRendaMensal()),
                new Idade(r.getIdade()),
                new Profissao(r.getProfissao())
        );
    }

    public ClienteResponse toResponse(Cliente c) {
        ClienteResponse resp = new ClienteResponse();
        resp.id = c.getId();
        resp.nome = c.getNome();
        resp.email = c.getEmail();
        resp.telefone = c.getTelefone();
        resp.cpf = c.getCpf();
        resp.rendaMensal = c.getRendaMensal();
        resp.idade = c.getIdade();
        resp.profissao = c.getProfissao();
        return resp;
    }
}
