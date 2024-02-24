package com.example.apiturismo;

import com.example.apiturismo.pojos.Cliente;
import com.example.apiturismo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que proporciona servicios de seguridad para la autenticación de usuarios.
 */
@Service
public class SecurityServices {

@Autowired
    private ClientRepository clientRepository;

    /**
     * Valida un token de autenticación para usuarios.
     *
     * @param token El token de autenticación a validar.
     * @return true si el token es válido y corresponde a un cliente registrado, false de lo contrario.
     */
    public Boolean validateTokerForUsers(String token) {
        Cliente cliente = clientRepository.getClienteByToken(token);
        if (cliente == null) {
            return false;
        }else{
            return true;
        }
    }
}
