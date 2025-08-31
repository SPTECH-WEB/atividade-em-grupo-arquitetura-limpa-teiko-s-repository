package com.credit.risk.avaliation.calculator.interfaces;

import com.credit.risk.avaliation.calculator.entities.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(UUID id);
}
