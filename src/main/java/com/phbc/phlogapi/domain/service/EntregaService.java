package com.phbc.phlogapi.domain.service;

import com.phbc.phlogapi.domain.exception.DomainException;
import com.phbc.phlogapi.domain.model.Cliente;
import com.phbc.phlogapi.domain.model.Entrega;
import com.phbc.phlogapi.domain.model.StatusEntrega;
import com.phbc.phlogapi.domain.repository.ClienteRepository;
import com.phbc.phlogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class EntregaService {

    private EntregaRepository entregaRepository;
    private ClienteService clienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}
