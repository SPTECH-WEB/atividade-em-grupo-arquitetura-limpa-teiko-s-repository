package com.credit.risk.avaliation.calculator.adapters.persistence;

import com.credit.risk.avaliation.calculator.entities.Cliente;
import com.credit.risk.avaliation.calculator.interfaces.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryClienteRepository implements ClienteRepository {

    private final Map<UUID, Cliente> storage = new ConcurrentHashMap<>();

    @Override
    public Cliente save(Cliente cliente) {
        storage.put(cliente.getId(), cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }
}
