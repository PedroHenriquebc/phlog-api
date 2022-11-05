package com.phbc.phlogapi.domain.service;

import com.phbc.phlogapi.domain.exception.DomainException;
import com.phbc.phlogapi.domain.model.Cliente;
import com.phbc.phlogapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new DomainException("Já existe um cliente cadastrado com este e-mail");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new DomainException("Cliente não encontrado."));
    }

    public boolean existsById(Long clienteId) {
        return clienteRepository.existsById(clienteId);
    }
}
