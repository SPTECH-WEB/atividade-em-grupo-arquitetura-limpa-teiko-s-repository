package com.credit.risk.avaliation.calculator.adapters.in.web;

import com.credit.risk.avaliation.calculator.adapters.in.web.dtos.ClienteRequest;
import com.credit.risk.avaliation.calculator.adapters.in.web.dtos.ClienteResponse;
import com.credit.risk.avaliation.calculator.entities.ClassificacaoRisco;
import com.credit.risk.avaliation.calculator.entities.Cliente;
import com.credit.risk.avaliation.calculator.interfaces.ClassificacaoRiscoService;
import com.credit.risk.avaliation.calculator.interfaces.ClienteRepository;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClassificacaoRiscoService riscoService;
    private final ClienteRepository repository;
    private final ClienteMapper mapper = new ClienteMapper();

    public ClienteController(ClassificacaoRiscoService riscoService, ClienteRepository repository) {
        this.riscoService = riscoService;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> criar(@Valid @RequestBody ClienteRequest req) {
        Cliente cliente = repository.save(mapper.toDomain(req));
        ClassificacaoRisco classif = riscoService.classificarRisco(cliente);
        ClienteResponse resp = mapper.toResponse(cliente);
        resp.risco = classif.getRisco().name();
        resp.estrategiaContato = classif.getEstrategiaContato();
        resp.prioridade = classif.getPrioridade();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscar(@PathVariable("id") UUID id) {
        Cliente cliente = repository.findById(id).orElseThrow(NoSuchElementException::new);
        ClassificacaoRisco classif = riscoService.classificarRisco(cliente);
        ClienteResponse resp = mapper.toResponse(cliente);
        resp.risco = classif.getRisco().name();
        resp.estrategiaContato = classif.getEstrategiaContato();
        resp.prioridade = classif.getPrioridade();
        return ResponseEntity.ok(resp);
    }
}
