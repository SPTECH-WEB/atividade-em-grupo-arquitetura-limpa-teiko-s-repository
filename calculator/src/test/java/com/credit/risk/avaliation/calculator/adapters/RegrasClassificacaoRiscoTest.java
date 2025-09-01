package com.credit.risk.avaliation.calculator.adapters;

import com.credit.risk.avaliation.calculator.entities.*;
import com.credit.risk.avaliation.calculator.entities.vo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegrasClassificacaoRiscoTest {
    @Test
    void riscoBaixo_quandoRendaAltaEIdadeMaior30() {
        var regras = new RegrasClassificacaoRisco();
        var cliente = new Cliente(null, new Nome("Ana"), new Email("ana@ex.com"), new Telefone("11999999999"),
                new Cpf("123.456.789-10"), new RendaMensal(7000), new Idade(35), new Profissao("Dev"));
        assertEquals(RiscoCredito.BAIXO, regras.avaliarRisco(cliente));
    }
}