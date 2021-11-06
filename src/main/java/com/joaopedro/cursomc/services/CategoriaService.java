package com.joaopedro.cursomc.services;
import com.joaopedro.cursomc.domain.Categoria;
import com.joaopedro.cursomc.repositories.CategoriaRepository;
import com.joaopedro.cursomc.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName(), null));
    }
}
