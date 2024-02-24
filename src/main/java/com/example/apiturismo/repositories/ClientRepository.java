package com.example.apiturismo.repositories;

import com.example.apiturismo.pojos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que define un repositorio para la entidad Cliente en el sistema de turismo.
 * Extiende JpaRepository para obtener métodos básicos.
 */

public interface ClientRepository extends JpaRepository<Cliente, Long> {

    /**
     * Obtiene un cliente por su token de autenticación.
     *
     * @param token El token de autenticación del cliente.
     * @return El cliente correspondiente al token dado, o null si no se encuentra.
     */
    public Cliente getClienteByToken(String token);
}
