package com.web_loja.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web_loja.domain.Cliente;
import com.web_loja.repositories.ClienteRespository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRespository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id); //Obj container - evita null point exception 
        return obj.orElseThrow(() -> new ObjectNotFoundException( //Retorna funcao q instancia uma execao caso obj não encontrado
            id, Cliente.class.getName()));

    }

}
