package com.credit.risk.avaliation.calculator.adapters;

import com.credit.risk.avaliation.calculator.entities.ClassificacaoRisco;
import com.credit.risk.avaliation.calculator.entities.Cliente;
import com.credit.risk.avaliation.calculator.entities.RiscoCredito;
import com.credit.risk.avaliation.calculator.interfaces.ClassificacaoRiscoService;
import org.springframework.stereotype.Service;

@Service
public class ClassificacaoRiscoServiceImpl implements ClassificacaoRiscoService {

    private final RegrasClassificacaoRisco regras;

    public ClassificacaoRiscoServiceImpl(RegrasClassificacaoRisco regras) {
        this.regras = regras;
    }

    @Override
    public ClassificacaoRisco classificarRisco(Cliente cliente) {
        RiscoCredito risco = regras.avaliarRisco(cliente);
        String estrategia = definirEstrategia(risco);
        int prioridade = definirPrioridade(risco);
        return new ClassificacaoRisco(risco, estrategia, prioridade);
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