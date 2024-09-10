package com.web_loja.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_loja.domain.Categoria;
import com.web_loja.repositories.CategoriaRespository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRespository repo;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id); //Obj container - evita null point exception 
        return obj.orElseThrow(() -> new ObjectNotFoundException( //Retorna funcao q instancia uma execao caso obj não encontrado
            id, Categoria.class.getName()));

    }

}
