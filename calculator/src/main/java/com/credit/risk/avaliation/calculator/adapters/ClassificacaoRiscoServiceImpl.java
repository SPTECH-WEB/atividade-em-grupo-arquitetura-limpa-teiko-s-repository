package com.credit.risk.avaliation.calculator.adapters;

import com.credit.risk.avaliation.calculator.entities.Cliente;
import entities.ClassificacaoRisco;
import entities.RiscoCredito;
import interfaces.ClassificacaoRiscoService;
import org.springframework.stereotype.Service;

@Service
public class ClassificacaoRiscoServiceImpl implements ClassificacaoRiscoService {

    @Override
    public ClassificacaoRisco classificarRisco(Cliente cliente) {
        RiscoCredito risco = determinarRisco(cliente);
        String estrategia = definirEstrategia(risco);
        int prioridade = definirPrioridade(risco);

        return new ClassificacaoRisco(risco, estrategia, prioridade);
    }

    private RiscoCredito determinarRisco(Cliente cliente) {
        double renda = cliente.getRendaMensal();
        int idade = cliente.getIdade();

        if (renda > 6000 && idade > 30) {
            return RiscoCredito.BAIXO;
        } else if ((renda >= 3000 && renda <= 6000) || idade <= 30) {
            return RiscoCredito.MEDIO;
        } else {
            return RiscoCredito.ALTO;
        }
    }

    private String definirEstrategia(RiscoCredito risco) {
        return switch (risco) {
            case BAIXO -> "Contato automático por e-mail";
            case MEDIO -> "Análise manual em até 48h";
            case ALTO -> "Contato telefônico em até 24h + análise crítica";
        };
    }

    private int definirPrioridade(RiscoCredito risco) {
        return switch (risco) {
            case BAIXO -> 3;
            case MEDIO -> 2;
            case ALTO -> 1;
        };
    }


}
