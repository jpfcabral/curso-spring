package com.joaopedro.cursomc.services;
import com.joaopedro.cursomc.domain.Cliente;
import com.joaopedro.cursomc.repositories.ClienteRepository;
import com.joaopedro.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), null));
    }
}
