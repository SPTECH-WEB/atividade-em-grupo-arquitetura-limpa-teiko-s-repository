package com.credit.risk.avaliation.calculator.interfaces;

import com.credit.risk.avaliation.calculator.entities.ClassificacaoRisco;
import com.credit.risk.avaliation.calculator.entities.Cliente;

public interface ClassificacaoRiscoService {
    ClassificacaoRisco classificarRisco(Cliente cliente);
}