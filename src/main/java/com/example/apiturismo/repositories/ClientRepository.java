package com.example.apiturismo.repositories;

import com.example.apiturismo.pojos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, Long> {

    public Cliente getClienteByToken(String token);
}
