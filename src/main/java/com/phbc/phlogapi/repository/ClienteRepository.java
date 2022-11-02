package com.phbc.phlogapi.repository;

import com.mysql.cj.xdevapi.Client;
import com.phbc.phlogapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByNome(String nome);
}
