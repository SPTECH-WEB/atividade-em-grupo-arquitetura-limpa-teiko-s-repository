package com.credit.risk.avaliation.calculator.adapters;

import com.credit.risk.avaliation.calculator.entities.Cliente;
import com.credit.risk.avaliation.calculator.entities.RiscoCredito;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class RegrasClassificacaoRisco {

    private final List<RegraRisco> regras = List.of(
            new RegraRisco(RiscoCredito.BAIXO, this::isRiscoBaixo),
            new RegraRisco(RiscoCredito.ALTO, this::isRiscoAlto),
            new RegraRisco(RiscoCredito.MEDIO, cliente -> true)
    );

    public RiscoCredito avaliarRisco(Cliente cliente) {
        return regras.stream()
                .filter(regra -> regra.condicao().apply(cliente))
                .map(RegraRisco::risco)
                .findFirst()
                .orElse(RiscoCredito.MEDIO);
    }

    private boolean isRiscoBaixo(Cliente cliente) {
        return cliente.getRendaMensal() > 6000 && cliente.getIdade() > 30;
    }

    private boolean isRiscoAlto(Cliente cliente) {
        return cliente.getRendaMensal() < 3000;
    }

    public record RegraRisco(RiscoCredito risco, Function<Cliente, Boolean> condicao) {}
}