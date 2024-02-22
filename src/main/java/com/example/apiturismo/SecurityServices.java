package com.example.apiturismo;

import com.example.apiturismo.pojos.Cliente;
import com.example.apiturismo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServices {

@Autowired
    private ClientRepository clientRepository;

    public Boolean validateTokerForUsers(String token) {
        Cliente cliente = clientRepository.getClienteByToken(token);
        if (cliente == null) {
            return false;
        }else{
            return true;
        }
    }
}
